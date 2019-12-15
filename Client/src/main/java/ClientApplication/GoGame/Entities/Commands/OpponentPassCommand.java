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

public class OpponentPassCommand extends Command {
    
    public OpponentPassCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
		((GameBoardController)gameGui.getFrame().getController()).showOpponentPass();
	}


}
