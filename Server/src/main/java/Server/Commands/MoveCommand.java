package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.MoveInfo;

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
		
		if (this.game.getGameLogic().move(message.getX(), message.getY(), playerNumber)) {
		    try {
		        int[][] emptyPlaces = this.game.getGameLogic().removeDeathStones(message.getX(), message.getY());
		        this.game.getActualPlayer().addPoints(emptyPlaces.length);
		        MoveInfo moveInfo = new MoveInfo(playerNumber, true, message.getX(), message.getY(), emptyPlaces);
                this.game.getActualPlayer().sendMessage(moveInfo);
                this.game.changeActualPlayer();
                this.game.getActualPlayer().sendMessage(moveInfo);
                this.game.setPreviousPass(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
		} else {
		    try {
                this.game.getActualPlayer().sendMessage(new MoveInfo(0, false, 0, 0, null));
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}

}
