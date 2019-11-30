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
import Server.ServerMessage.OponentMove;
import Server.ServerMessage.ServerMessage;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication {

	public static void main(String[] args) {
			
		try {
			Client client = new Client("localhost", 59898);
			System.out.println("KONCZE PRACE LOLOLOL");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		}
		// TODO warunki dla game settings
		// dla nulla odbierz dane i stworz ustawienia,grę.wyślij opcje
		// dla wypelnionego stworz grę

	}
