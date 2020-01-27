package Server.Commands;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Database.Entities.GoGame;
import Server.Database.Entities.Movement;
import Server.Database.Service.Interfaces.MovementService;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;

@Component
public class SurrenderCommand extends Command {
  
  @Autowired
  protected MovementService movementService;
  
  public SurrenderCommand() {}
    
    public SurrenderCommand(ClientMessage message) {
        super(message);
    }

	@Override
	public void executeCommand(Game game, Player player, GoGame goGame) {
	      game.getGameLogic().removeDeathStonesEndGame();
	      
	      Movement movement = new Movement("surrender", -1, -1, game.getActualPlayer().getNumber(), goGame);
	      this.movementService.saveMovement(movement);
        
        int player1Points = game.getGameLogic().countPoints(1) + game.getPlayer1().getPoints();
        int player2Points = game.getGameLogic().countPoints(2) + game.getPlayer2().getPoints();
        
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
