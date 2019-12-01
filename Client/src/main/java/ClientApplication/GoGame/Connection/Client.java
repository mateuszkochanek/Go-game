package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

import ClientApplication.GoGame.Command.Factory.CommandFactory;
import ClientApplication.GoGame.Command.Factory.ConcreteCommandFactory;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.Commands.Command;
import Server.ServerMessage.ServerMessage;

public class Client { // zamykanie i otwieranie połączenia
	ClientConnection clientConnection;
    CommandFactory commandFactory;
	//ExecutorService threads;
	
	public Client(String ipAdress,int port) throws UnknownHostException, IOException {
	    this.commandFactory = new ConcreteCommandFactory();
	    //ExecutorService threads =  Executors.newFixedThreadPool(20);
		this.initializeClientConnection(ipAdress,port);
	}
	
	//this method creates connection and output/input object streams
	private void initializeClientConnection(String ipAdress,int port) throws UnknownHostException, IOException {
        this.clientConnection = new ClientConnection(ipAdress,port,this);
        this.clientConnection.read();
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
	    Command command = this.commandFactory.getCommand(this, serverMessage);
	    var threads = Executors.newFixedThreadPool(20);
	    threads.execute(command);
	}
	
	public void sendMessage(ClientMessage clientMessage) throws IOException {
	    this.clientConnection.sendMessageToServer(clientMessage);
	}
	
}
