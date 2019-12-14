package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.OpponentPass;

public class PassCommand extends Command {
    
    public PassCommand(Game game, ClientMessage message, Player player) {
        super(game, message, player);
    }

	@Override
	public void executeCommand() {
	    
	    if (!this.game.getActualPlayer().equals(this.player)) {
            return;
        }
		
	    if (this.game.isPreviousPass()) {
	        this.game.getGameEnd().removeDeathStones();
	        
	        int player1Points = this.game.getGameEnd().countPoints(1);
	        int player2Points = this.game.getGameEnd().countPoints(2);
	        
	        try {
                this.game.getPlayer1().sendMessage(new EndGame(false, 0, player1Points, player2Points));
                this.game.getPlayer2().sendMessage(new EndGame(false, 0, player1Points, player2Points));
            } catch (IOException e) {
                e.printStackTrace();
            }
	        
	        //TODO: new game?
	    } else {
	        this.game.setPreviousPass(true);
	        this.game.changeActualPlayer();
	        try {
                this.game.getActualPlayer().sendMessage(new OpponentPass());
            } catch (IOException e) {
                e.printStackTrace();
            }
	    }	    
	}

}
