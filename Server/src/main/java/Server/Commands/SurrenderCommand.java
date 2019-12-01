package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class SurrenderCommand extends Command {
    
    public SurrenderCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	protected void executeCommand() {
		
		
	}

}
