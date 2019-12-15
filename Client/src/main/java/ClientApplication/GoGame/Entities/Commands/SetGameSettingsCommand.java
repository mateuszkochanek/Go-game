package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Frame.GameBoardFrame;
import ClientApplication.GoGame.Gui.Frame.NewGameFrame;
import Server.ServerMessage.SentGameOptions;
import Server.ServerMessage.ServerMessage;

public class SetGameSettingsCommand extends Command {
    
	public SetGameSettingsCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

    @Override
    public void executeCommand() {
    	int size = ((SentGameOptions)serverMessage).getSize();
        gameGui.setFrame(new GameBoardFrame(gameGui, size));
        gameGui.getStage().close();
        gameGui.setStage(gameGui.getFrame().getStage());
        gameGui.getStage().show();
	}



}
