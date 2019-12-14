package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
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
		System.out.println("blackpoints: " + blackPoint + " whitePoint: " + whitePoint + "surr: " + surrenderPlayer);
		gameGui.createEndGameFrame(isSurrender,blackPoint,whitePoint,surrenderPlayer);
	}


}
