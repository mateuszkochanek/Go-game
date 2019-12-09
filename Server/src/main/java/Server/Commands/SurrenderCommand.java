package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class SurrenderCommand extends Command {
    
    public SurrenderCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	public void executeCommand() {
		/**
		 * TODO:
		 * game.endGame() -> choose death group, counting points
		 * send info to both players
		 * play again (?)
		 */
	}

}
