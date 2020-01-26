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
import Server.ServerMessage.OpponentPass;

@Component
public class PassCommand extends Command {
  
  @Autowired
  protected MovementService movementService;
  
  public PassCommand() {}
    
    public PassCommand(ClientMessage message) {
        super(message);
    }

	@Override
	public void executeCommand(Game game, Player player, GoGame goGame) {
	    
	    if (!game.getActualPlayer().equals(player)) {
            return;
        }
	    
	    Movement movement = new Movement("pass", -1, -1, game.getActualPlayer().getNumber(), goGame);
      this.movementService.saveMovement(movement);
		
	    if (game.isPreviousPass()) {
	        game.getGameLogic().removeDeathStonesEndGame();
	        
	        int player1Points = game.getGameLogic().countPoints(1) + game.getPlayer1().getPoints();
	        int player2Points = game.getGameLogic().countPoints(2) + game.getPlayer2().getPoints();
	        
	        try {
                game.getPlayer1().sendMessage(new EndGame(false, 0, player1Points, player2Points));
                game.getPlayer2().sendMessage(new EndGame(false, 0, player1Points, player2Points));
            } catch (IOException e) {
                e.printStackTrace();
            }
	        
	    } else {
	        game.setPreviousPass(true);
	        game.changeActualPlayer();
	        try {
                game.getActualPlayer().sendMessage(new OpponentPass());
            } catch (IOException e) {
                e.printStackTrace();
            }
	    }	    
	}

}
