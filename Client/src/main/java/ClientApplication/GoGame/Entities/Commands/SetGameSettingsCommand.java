package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.ServerMessage;

public class SetGameSettingsCommand extends Command {
    
	public SetGameSettingsCommand(Client client, ServerMessage message) {
        super(client, message);
    }

    @Override
	protected void executeCommand() {
		ClientMessage clientMessage;
		// dostajemy stworzone game settings
		
		
	}

}
