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
        	
        	//TODO stworz pierwszego humana
        	
        	//wyslij info o game setting(beda nullami)
        	
        	// obierz info o game settings
        	
        	//stworz drugiego gracza
        	
        	//TODO stworz w  innym pliku klasę game (narazie tylko wywolanie)
        	//stworz gre(przekaz graczy i int size)
            System.out.println("The GOGAME server is running...");
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Human(listener.accept()));
            }
        }
    }
}
