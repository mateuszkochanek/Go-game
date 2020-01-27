package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Frame.NewGameFrame;
import Server.ServerMessage.NewGame;
import Server.ServerMessage.ServerMessage;
import javafx.application.Platform;

public class NewGameCommand extends Command {
    
    public NewGameCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
            gameGui.setFrame(new NewGameFrame(gameGui,((NewGame) serverMessage).getGamesIdList()));
            gameGui.getStage().close();
            gameGui.setStage(gameGui.getFrame().getStage());
            gameGui.getStage().show();
	}

}
