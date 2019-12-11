package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;
import javafx.application.Platform;

public class NewGameCommand extends Command {
    
    public NewGameCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
			System.out.println("GOD");
            gameGui.CreateNewGameFrame();
            System.out.println("GOD paased");
	}

}
