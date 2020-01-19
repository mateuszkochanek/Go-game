package Client.Connection;

import java.io.IOException;
import java.net.UnknownHostException;

import Client.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

public interface Client {
	public void sendMessage(ClientMessage clientMessage) throws IOException;
	void getServerMessage(ServerMessage serverMessage);	
	public void startConnection();	
	public void closeConnection() ;
	public void sendMessageToServer(ClientMessage message) throws IOException;
}
