package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.Game.Game;
public class MoveCommand extends Command {
    
    public MoveCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	public void executeCommand() {
		Move message = (Move) this.clientMessage;
		
		/**
		 * TODO;
		 * this.game.checkMove();
		 * true
		 *    send to actual player MoveInfo(true)
		 *    change game.actualplayer
		 *    send to actual player OpponentInfo
		 *    set game.previousPass to false
		 * false
		 *    send to actual player MoveInfo(false)
		 */
	}

}
