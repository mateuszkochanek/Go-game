package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;

public class SurrenderCommand extends Command {
    
    public SurrenderCommand(ClientMessage message) {
        super(message);
    }

	@Override
	public void executeCommand(Game game, Player player) {
	    game.getGameLogic().removeDeathStonesEndGame();
        
        int player1Points = game.getGameLogic().countPoints(1) + game.getPlayer1().getPoints();
        int player2Points = game.getGameLogic().countPoints(2) + game.getPlayer2().getPoints();
        
        System.out.println(player1Points + " " + player2Points);
        
        try {
            if (game.getPlayer1().equals(player)) {
                EndGame endGame = new EndGame(true, 1, player1Points, player2Points);
                game.getPlayer1().sendMessage(endGame);
                game.getPlayer2().sendMessage(endGame);
            } else {
                EndGame endGame = new EndGame(true, 2, player1Points, player2Points);
                game.getPlayer1().sendMessage(endGame);
                game.getPlayer2().sendMessage(endGame);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
