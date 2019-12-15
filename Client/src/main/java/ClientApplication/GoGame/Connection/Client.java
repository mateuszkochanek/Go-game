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

public class Client extends ClientConnection{ // zamykanie i otwieranie połączenia
    GameGui gameGui;

	public Client(String ipAdress,int port) throws UnknownHostException, IOException {
		super(ipAdress, port);
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
	    gameGui.getServerMessage(serverMessage);
	}
	
	public void sendMessage(ClientMessage clientMessage) throws IOException {
	    this.sendMessageToServer(clientMessage);
	}

	public GameGui getGameGui() {
		return gameGui;
	}

	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}
	
}
