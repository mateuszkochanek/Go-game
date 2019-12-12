package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;

public class SetGameSettingsCommand extends Command {
    
	public SetGameSettingsCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

    @Override
    public void executeCommand() {
    	gameGui.CreateGameBoard9Frame();
	}



}
