package Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.GameSettings;

public class Server 
{
	public static void main(String[] args) {  
	    createServer();
    }
	
	private static void createServer() {
	    try (ServerSocket listener = new ServerSocket(59898)) { 
            Socket socket = listener.accept();
            Player player1 = null;
            
            var pool = Executors.newFixedThreadPool(20);
            pool.execute(player1 = new Human(socket));
            
            TimeUnit.SECONDS.sleep(1);
            
            player1.sendMessage(new GameSettings(0, null));
            
	    } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
