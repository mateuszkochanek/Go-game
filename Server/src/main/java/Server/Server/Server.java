package Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Server.Game.Game;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.NewGame;

public class Server 
{
	public static void main(String[] args) {  
	    createServer();
    }
	
	private static void createServer() {
	    try (ServerSocket listener = new ServerSocket(59898)) { 
            Socket socket = listener.accept();
            Game game = new Game();
            Player player1 = null;
            
            var pool = Executors.newFixedThreadPool(20);
            pool.execute(player1 = new Human(socket,game));
            game.setPlayer1(player1);
            
            TimeUnit.SECONDS.sleep(1);
            
            player1.sendMessage(new NewGame());
            
	    } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
