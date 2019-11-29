package Server.Server;

import java.net.ServerSocket;

import java.util.concurrent.Executors;

import Server.Player.Human;
/**
 * Hello world!
 *
 */
public class Server 
{
	public static void main(String[] args) throws Exception {  
        try (var listener = new ServerSocket(59898)) {
            System.out.println("The GOGAME server is running...");
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Human(listener.accept()));
            }
        }
    }
}
