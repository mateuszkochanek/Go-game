package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.Game.Game;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentMove;
public class MoveCommand extends Command {
    
    public MoveCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	public void executeCommand() {
		Move message = (Move) this.clientMessage;
		
		int player;
		if (this.game.getActualPlayer().equals(this.game.getPlayer1())) {
		    player = 1;
		} else {
		    player = 2;
		}
		
		if (this.game.getGameLogic().checkMove(message.getX(), message.getY(), player)) {
		    try {
                this.game.getActualPlayer().sendMessage(new MoveInfo(true));
                this.game.changeActualPlayer();
                this.game.getActualPlayer().sendMessage(new OpponentMove(message.getX(), message.getY()));
                this.game.setPreviousPass(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
		} else {
		    try {
                this.game.getActualPlayer().sendMessage(new MoveInfo(false));
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}

}
