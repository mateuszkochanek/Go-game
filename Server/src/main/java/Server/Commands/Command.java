package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public abstract class Command {
	Game game;
	ClientMessage clientMessage;
	
	protected Command(Game game, ClientMessage message) {
	    this.game = game;
	    this.clientMessage = message;
	}
	
	protected abstract void executeCommand();


}
