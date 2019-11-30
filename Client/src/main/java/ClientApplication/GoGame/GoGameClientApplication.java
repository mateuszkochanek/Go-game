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
		Client client;
		try {
			client = new Client("localhost", 59898);
			// TODO while true z getMessageFromServer() i sendMessageToServer
			while (true) {
				ServerMessage serverGotMessage = null;
				ClientMessage clientSendMessage = null;
					serverGotMessage = client.getMessageFromServer();

				if (serverGotMessage instanceof GameSettings) {
					if (((GameSettings) serverGotMessage).getMode() == null) {
						// będziemy wysylac stworzone game options
						clientSendMessage = new SetGameOptions(19, "hotseat");
						// TODO stworz tu game settings i grę
						// Game game = new Game(((GameSettings) serverGotMessage).getSize())
					} else {
						// TODO stworz grę na podstawie odebranych settingów
						// Game game = new Game(((GameSettings) serverGotMessage).getSize())
						clientSendMessage = new SetGameOptions(0, null);
					}
				} else if (serverGotMessage instanceof OponentMove) {
					// TODO zupdateuj grę na podstawie informacji o ruchu przeciwnika
					// game.update(serverGotMessage)
					clientSendMessage = new Move(1, 1);
				} else if (serverGotMessage instanceof MoveInfo) {
					if (((MoveInfo) serverGotMessage).isCorrectMove()) {
						// TODO zupdateuj grę na podstawie informacji o swoim ruchu
						// TODO informacja że zakończyłeś turę? pass jako ta informacja?
						clientSendMessage = new Pass();
					} else {
						clientSendMessage = new Move(1, 2);
					}
				}
				client.sendMessageToServer(clientSendMessage);
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		// TODO warunki dla game settings
		// dla nulla odbierz dane i stworz ustawienia,grę.wyślij opcje
		// dla wypelnionego stworz grę

	}
