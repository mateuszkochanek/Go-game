package ClientApplication.GoGame.Entities.Commands;

import javafx.concurrent.Task;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;

public abstract class Command{
	GameGui gameGui;
	ServerMessage serverMessage;
	
	protected Command(GameGui gameGui, ServerMessage message) {
	    this.gameGui = gameGui;
	    this.serverMessage = message;
	}

	public abstract void executeCommand();


}
