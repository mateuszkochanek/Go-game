package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class MoveCommand extends Command {
    
    public MoveCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	public void executeCommand() {
		
	}

}
