package Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Game.Game;
import Server.Player.Bot;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.NewGame;
import Server.ServerMessage.SentGameOptions;

public class Server  {
    
    private void prepareGame() {
        ServerSocket listener = null;
        Connection connection = null;
        int boardSize;
        
        try {
            listener = new ServerSocket(59898);
            connection = new Connection(listener);
            connection.sendMessage(new NewGame());
                 
            TimeUnit.SECONDS.sleep(1);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        Player player1 = new Human(connection, 1);
        Player player2 = null;

        SetGameOptions message = (SetGameOptions) connection.getMessage();
        
        boardSize = message.getSize();
        
        if (message.getMode().contentEquals("hotseat")) {
            
           player2 = new Human(connection, 2);
            
            try {
                player1.sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else if (message.getMode().contentEquals("singleplayer")) {
            
            var pool = Executors.newFixedThreadPool(20);
            pool.execute(player2 = new Bot(2, boardSize));
            
            try {
                player1.sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else if (message.getMode().contentEquals("multiplayer")) {
            
            Connection connection2 = new Connection(listener);
            player2 = new Human(connection2, 2);
        
            try {
                player1.sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
                player2.sendMessage(new SentGameOptions(2, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
        var pool = Executors.newFixedThreadPool(20);
        pool.execute(player1);
        pool.execute(player2);
        Game game = new Game(player1, player2, boardSize);
        player1.setGame(game);
        player2.setGame(game);
    }
    
	public static void main(String[] args) {  
	    Server server = new Server();
	    server.prepareGame();
    }
}
