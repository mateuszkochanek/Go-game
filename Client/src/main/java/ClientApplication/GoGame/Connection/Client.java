package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import ClientApplication.GoGame.Entities.Game.Game;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OponentMove;
import Server.ServerMessage.ServerMessage;



public class Client { // zamykanie i otwieranie połączenia
	ClientConnection clientConnection;
	
	public Client(String ipAdress,int port) throws UnknownHostException, IOException {
		this.initializeClientConnection(ipAdress,port);
	}
	//this method creates connection and output/input object streams
	private void initializeClientConnection(String ipAdress,int port) throws UnknownHostException, IOException {
		var pool = Executors.newFixedThreadPool(20);
        pool.execute(clientConnection = new ClientConnection(ipAdress,port,this));
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
		ClientMessage clientMessage = null;
		if (serverMessage instanceof GameSettings) {
			if (((GameSettings) serverMessage).getMode() == null) {
				// będziemy wysylac stworzone game options
				clientMessage = new SetGameOptions(19, "hotseat");
				// TODO stworz tu game settings i grę
				// Game game = new Game(((GameSettings) serverGotMessage).getSize())
			} else {
				// TODO stworz grę na podstawie odebranych settingów
				// Game game = new Game(((GameSettings) serverGotMessage).getSize())
				clientMessage = new SetGameOptions(0, null);
			}
		} else if (serverMessage instanceof OponentMove) {
			// TODO zupdateuj grę na podstawie informacji o ruchu przeciwnika
			// game.update(serverGotMessage)
			clientMessage = new Move(1, 1);
		} else if (serverMessage instanceof MoveInfo) {
			if (((MoveInfo) serverMessage).isCorrectMove()) {
				// TODO zupdateuj grę na podstawie informacji o swoim ruchu
				// TODO informacja że zakończyłeś turę? pass jako ta informacja?
				clientMessage = new Pass();
			} else {
				clientMessage = new Move(1, 2);
			}
		}
		try {
			sendMessage(clientMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendMessage(ClientMessage clientMessage) throws IOException {
		clientConnection.sendMessageToServer(clientMessage);
	}
	
}
