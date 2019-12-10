package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentMove;
public class MoveCommand extends Command {
    
    public MoveCommand(Game game, ClientMessage message, Player player) {
        super(game, message, player);
    }

	@Override
	public void executeCommand() {
		Move message = (Move) this.clientMessage;
		
		if (!this.game.getActualPlayer().equals(this.player)) {
		    return;
		}
		
		int playerNumber;
		if (this.game.getActualPlayer().equals(this.game.getPlayer1())) {
		    playerNumber = 1;
		} else {
		    playerNumber = 2;
		}
		
		if (this.game.getGameLogic().checkMove(message.getX(), message.getY(), playerNumber)) {
		    try {
		        this.game.getGameLogic().removeDeathStones(message.getX(), message.getY());
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
