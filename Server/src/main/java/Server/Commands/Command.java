package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Player.Player;

public abstract class Command {
	Game game;
	ClientMessage clientMessage;
	Player player;
	
	protected Command(Game game, ClientMessage message, Player player) {
	    this.game = game;
	    this.clientMessage = message;
	    this.player = player;
	}
	
	public abstract void executeCommand();


}
