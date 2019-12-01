package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import Server.ServerMessage.ServerMessage;

public abstract class Command implements Runnable {
	Client client;
	ServerMessage serverMessage;
	
	@Override
	public void run() {
		executeCommand();
	}
	
	protected abstract void executeCommand();


}
