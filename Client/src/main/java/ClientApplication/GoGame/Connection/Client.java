package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ClientApplication.GoGame.Command.Factory.CommandFactory;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OponentMove;
import Server.ServerMessage.ServerMessage;



public class Client { // zamykanie i otwieranie połączenia
	ClientConnection clientConnection;
	CommandFactory commandFactory;
	ExecutorService threads;
	
	public Client(String ipAdress,int port) throws UnknownHostException, IOException {
		this.initializeClientConnection(ipAdress,port);
		ExecutorService threads =  Executors.newFixedThreadPool(20);
	}
	
	//this method creates connection and output/input object streams
	private void initializeClientConnection(String ipAdress,int port) throws UnknownHostException, IOException {
        clientConnection = new ClientConnection(ipAdress,port,this);
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
	    //Command command = this.commandFactory.getCommand(serverMessage);
	    //threads.execute(command);
	}
	
	public void sendMessage(ClientMessage clientMessage) throws IOException {
		clientConnection.sendMessageToServer(clientMessage);
	}
	
}
