package Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Database.Entities.GoGame;
import Server.Database.Entities.Movement;
import Server.Database.Service.Interfaces.GoGameService;
import Server.Game.Game;
import Server.Game.GameLogic;
import Server.Player.Bot;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.NewGame;
import Server.ServerMessage.SentGameOptions;

@Component
public class Server   {
  
  @Autowired
  GoGameService goGameService;
  @Autowired
  Game game;
  
  @Autowired
  Game game;
  
    public Server() {
    }
    
    @EventListener
    public void prepareGame(ContextRefreshedEvent event) {
        ServerSocket listener = null;
        Connection connection = null;
        Player player1 = null;
        Player player2 = null;
        int boardSize = 0;
        boolean ifHotseat = false;
        
        try {
            listener = new ServerSocket(59898);
            connection = new Connection(listener);
            TimeUnit.SECONDS.sleep(1);
            connection.sendMessage(new NewGame());
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        player1 = new Human(connection, 1);

        SetGameOptions message = (SetGameOptions) connection.getMessage();
        boardSize = message.getSize();
        
        if (message.getMode().contentEquals("hotseat")) {
            
            ifHotseat = true;
            player2 = new Human(connection, 2);
            
            try {
                player1.sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else if (message.getMode().contentEquals("singleplayer")) {
            
            player2 = new Bot(2, boardSize);
            
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
        
        ExecutorService pool = Executors.newFixedThreadPool(20);
        pool.execute(player1);
        
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        pool.execute(player2);
        GoGame goGame = this.saveGame(message);
        goGame = this.goGameService.getGame();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setActualPlayer(player1);
        game.setGameLogic(new GameLogic(boardSize));
        game.setHotseat(ifHotseat);
        game.setGoGame(goGame);
        player1.setGame(game);
        player2.setGame(game);
    }
    
    private GoGame saveGame(SetGameOptions message) {
      
      GoGame goGame = new GoGame();
      goGame.setDate(new Date(System.currentTimeMillis()));
      goGame.setType(message.getMode());
      goGame.setSize(message.getSize());
      
      goGameService.saveGame(goGame);
      
      return goGame;
    }
}
