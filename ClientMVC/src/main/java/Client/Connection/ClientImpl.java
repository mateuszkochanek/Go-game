package Client.Connection;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Client.AppController;
import Client.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

@Component
public class ClientImpl extends ClientConnection implements Client{ // zamykanie i otwieranie połączenia


	public ClientImpl() throws UnknownHostException, IOException {
		super("localhost", 59898);
	}
	
	//public void getServerMessage(ServerMessage serverMessage) {
	 //   gameGui.getServerMessage(serverMessage);
	//}
	
	public void sendMessage(ClientMessage clientMessage) throws IOException {
	    this.sendMessageToServer(clientMessage);
	}

	public void getServerMessage(ServerMessage serverMessage) {
		// TODO Auto-generated method stub
		
	}

	//public GameGui getGameGui() {
	//	return gameGui;
	//}

	//public void setGameGui(GameGui gameGui) {
	//	this.gameGui = gameGui;
	//}
	
}
