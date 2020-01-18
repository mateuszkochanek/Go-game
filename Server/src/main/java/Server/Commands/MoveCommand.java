package Server.Commands;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.Database.Entities.GoGame;
import Server.Database.Entities.Movement;
import Server.Database.Service.MovementServiceImpl;
import Server.Database.Service.Interfaces.MovementService;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.MoveInfo;

public class MoveCommand extends Command {
    
  @Autowired
  protected MovementService movementService;
  
    public MoveCommand(ClientMessage message) {
        super(message);
    }

	@Override
	public void executeCommand(Game game, Player player, GoGame goGame) {
		Move message = (Move) this.clientMessage;
		    
		if (!game.getActualPlayer().equals(player) && !game.isHotseat())
		    return;

		if (game.getGameLogic().move(message.getX(), message.getY(), game.getActualPlayer().getNumber())) {
		    try {
		      this.movementService = new MovementServiceImpl();
		        Movement movement = new Movement("move", message.getX(), message.getY(), game.getActualPlayer().getNumber(), goGame);
		        this.movementService.saveMovement(movement);
		      
		        int[][] emptyPlaces = game.getGameLogic().removeDeathStones(message.getX(), message.getY());
		        game.getActualPlayer().addPoints(emptyPlaces.length);
		        MoveInfo moveInfo = new MoveInfo(game.getActualPlayer().getNumber(), true, message.getX(), message.getY(), emptyPlaces);
                game.getActualPlayer().sendMessage(moveInfo);
                game.changeActualPlayer();
                game.getActualPlayer().sendMessage(moveInfo);
                game.setPreviousPass(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
		} else {
		    try {
                game.getActualPlayer().sendMessage(new MoveInfo(0, false, 0, 0, null));
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}

}
