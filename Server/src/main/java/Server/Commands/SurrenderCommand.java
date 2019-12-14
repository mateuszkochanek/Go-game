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
	    this.game.getGameLogic().removeDeathStonesEndGame();
        
        int player1Points = this.game.getGameLogic().countPoints(1) + this.game.getPlayer1().getPoints();
        int player2Points = this.game.getGameLogic().countPoints(2) + this.game.getPlayer2().getPoints();
        
        System.out.println(player1Points + " " + player2Points);
        
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
