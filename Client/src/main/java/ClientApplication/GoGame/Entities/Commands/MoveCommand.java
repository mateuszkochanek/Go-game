package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Controller.GameBoardController;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.ServerMessage;

public class MoveCommand extends Command {
    
    public MoveCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
		boolean doMove = ((MoveInfo) serverMessage).isCorrectMove();
		int x = ((MoveInfo) serverMessage).getX();
		int y = ((MoveInfo) serverMessage).getY();
		int[][] empty = ((MoveInfo) serverMessage).getEmptyPlaces();
		int color = ((MoveInfo) serverMessage).getPlayer();
		
		if(doMove) {
			((GameBoardController)gameGui.getFrame().getController()).showMove(x, y, color);
			((GameBoardController)gameGui.getFrame().getController()).emptyPlaces(empty);
		} else {
			//TODO what to do when move is not correct?
		}
	}


}
