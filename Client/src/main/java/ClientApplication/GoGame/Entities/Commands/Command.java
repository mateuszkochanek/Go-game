package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import Server.ServerMessage.ServerMessage;

public abstract class Command implements Runnable {
	Client client;
	ServerMessage serverMessage;
	
	protected Command(Client client, ServerMessage message) {
	    this.client = client;
	    this.serverMessage = message;
	}
	
	@Override
	public void run() {
		executeCommand();
	}
	
	protected abstract void executeCommand();


}
