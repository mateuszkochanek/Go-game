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
	    this.game.getGameEnd().removeDeathStones();
        
        int player1Points = this.game.getGameEnd().countPoints(1);
        int player2Points = this.game.getGameEnd().countPoints(2);
        
        try {
            if (this.game.getPlayer1().equals(this.player)) {
                EndGame endGame = new EndGame(true, 1, player1Points, player2Points);
                this.game.getPlayer1().sendMessage(endGame);
                this.game.getPlayer2().sendMessage(endGame);
            } else {
                EndGame endGame = new EndGame(true, 2, player1Points, player2Points);
                this.game.getPlayer1().sendMessage(endGame);
                this.game.getPlayer2().sendMessage(endGame);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
