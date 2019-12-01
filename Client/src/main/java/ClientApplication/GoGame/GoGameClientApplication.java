package ClientApplication.GoGame;

import java.io.IOException;
import java.net.UnknownHostException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentMove;
import Server.ServerMessage.ServerMessage;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication {

	public static void main(String[] args) {
			
		try {
			Client client = new Client("localhost", 59898);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {//czekac bedzie na powtórzenie gry? 
			
		}

		}

	}
