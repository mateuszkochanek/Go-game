package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;

public class SurrenderCommand extends Command {
    
    public SurrenderCommand(Game game, ClientMessage message, Player player) {
        super(game, message, player);
    }

	@Override
	public void executeCommand() {
		/**
		 * TODO:
		 * game.endGame() -> choose death group, counting points
		 * send info to both players
		 * play again (?)
		 */
	    this.game.getGameEnd().removeDeathStones();
        
        int player1Points = this.game.getGameEnd().countPoints(1);
        int player2Points = this.game.getGameEnd().countPoints(2);
        
        try {
            this.game.getPlayer1().sendMessage(new EndGame(true, player1Points, player2Points));
            this.game.getPlayer2().sendMessage(new EndGame(true, player1Points, player2Points));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
