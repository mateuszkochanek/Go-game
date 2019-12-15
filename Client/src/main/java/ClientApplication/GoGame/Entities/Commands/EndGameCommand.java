package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Frame.EndGameFrame;
import ClientApplication.GoGame.Gui.Frame.GameBoardFrame;
import Server.ServerMessage.ServerMessage;
import Server.ServerMessage.EndGame;

public class EndGameCommand extends Command {
    
    public EndGameCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
		int blackPoint = ((EndGame)serverMessage).getplayer1Points();
		int whitePoint = ((EndGame)serverMessage).getplayer2Points();
		int surrenderPlayer = ((EndGame)serverMessage).getPlayerSurrender();
		boolean isSurrender = ((EndGame)serverMessage).isSurrender();
		
		gameGui.setFrame(new EndGameFrame(gameGui, isSurrender, surrenderPlayer, blackPoint, whitePoint));
        gameGui.getStage().close();
        gameGui.setStage(gameGui.getFrame().getStage());
        gameGui.getStage().show();
	}


}
