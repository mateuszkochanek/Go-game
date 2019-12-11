package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ClientApplication.GoGame.Command.Factory.CommandFactory;
import ClientApplication.GoGame.Command.Factory.ConcreteCommandFactory;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;

public class Client { // zamykanie i otwieranie połączenia
	ClientConnection clientConnection;
    CommandFactory commandFactory;
    GameGui gameGui;
    ExecutorService threads = Executors.newFixedThreadPool(20);
	//ExecutorService threads;
	
	public Client(String ipAdress,int port) throws UnknownHostException, IOException {
	    this.commandFactory = new ConcreteCommandFactory();
	    this.clientConnection = new ClientConnection(ipAdress,port,this);
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
	    Command command = this.commandFactory.getCommand(gameGui, serverMessage);
	    command.executeCommand();
	    
	}
	
	public void sendMessage(ClientMessage clientMessage) throws IOException {
	    this.clientConnection.sendMessageToServer(clientMessage);
	}

	public ClientConnection getClientConnection() {
		return clientConnection;
	}

	public void setClientConnection(ClientConnection clientConnection) {
		this.clientConnection = clientConnection;
	}

	public GameGui getGameGui() {
		return gameGui;
	}

	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}
	
}
