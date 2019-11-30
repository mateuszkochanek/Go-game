package Server.Server;

import java.net.ServerSocket;

import java.util.concurrent.Executors;

import Server.ClientMessages.ClientMessage;
import Server.ClientMessages.SetGameOptions;
import Server.Game.Game;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.GameSettings;
/**
 * Hello world!
 *
 */
public class Server 
{
	public static void main(String[] args) throws Exception {  
        try (ServerSocket listener = new ServerSocket(59898)) { 
        	//TODO stworz pierwszego humana
            Player player1 = null;
            Player player2 = null;
            
            var pool = Executors.newFixedThreadPool(20);
            pool.execute(player1 = new Human(listener.accept()));
                    
        	//wyslij info o game setting(beda nullami)
            
            for (int i = 0; i < 100000; i++)
                for (int j = 0; j < 100000; j++)
                    for (int k = 0; k < 1000; k++);
            
            System.out.printf("Trying to send message ");
            player1.sendMessage(new GameSettings(0, null));
            System.out.printf("It works!");
        	
        	// obierz info o game settings
            
            ClientMessage message = player1.getMessage();
        	
        	//stworz drugiego gracza
            
            if (message instanceof SetGameOptions) {
                if (((SetGameOptions) message).getMode().equals("hotseat")) {
                    pool.execute(player2 = new Human(listener.accept()));
                }
            }
        	
        	//TODO stworz w  innym pliku klasę game (narazie tylko wywolanie)
            //Done
            
        	//stworz gre(przekaz graczy i int size)
            Game game = new Game(player1, player2, ((SetGameOptions) message).getSize());
            
            System.out.println("The GOGAME server is running...");
            /*var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Human(listener.accept()));
            }*/
        }
    }
}
