package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class SetGameOptionsCommand extends Command {
    
	public SetGameOptionsCommand(Game game, ClientMessage message) {
        super(game, message);
    }

    @Override
	protected void executeCommand() {
		
	}

}
