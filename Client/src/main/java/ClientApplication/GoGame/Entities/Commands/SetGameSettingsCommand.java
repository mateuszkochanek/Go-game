package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.ServerMessage;

public class SetGameSettingsCommand extends Command {
    
	public SetGameSettingsCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

    @Override
    public void executeCommand() {

		
	}



}
