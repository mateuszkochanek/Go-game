package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.ServerMessage;

public class MoveCommand extends Command {
    
    public MoveCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {

	}


}
