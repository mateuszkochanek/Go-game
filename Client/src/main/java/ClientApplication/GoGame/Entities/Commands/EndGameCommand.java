package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.ServerMessage;

public class EndGameCommand extends Command {
    
    public EndGameCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
		int blackPoint = ((EndGame)serverMessage).getPlayer1points();
		int whitePoint = ((EndGame)serverMessage).getPlayer2points();
		int surrenderPlayer = ((EndGame)serverMessage).getPlayerSurrender();
		boolean isSurrender = ((EndGame)serverMessage).isSurrender();
		gameGui.createEndGameFrame(isSurrender,blackPoint,whitePoint,surrenderPlayer);
	}


}
