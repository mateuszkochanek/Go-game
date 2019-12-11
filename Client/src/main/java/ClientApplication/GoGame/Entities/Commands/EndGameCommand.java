package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;

public class EndGameCommand extends Command {
    
    public EndGameCommand(GameGui gameGui, ServerMessage message) {
        super(gameGui, message);
    }

	@Override
	public void executeCommand() {
		// TODO Surrender i EndGame do implementacji!
		//Surrender też tutaj?
		//zamykanie gry, wyswietlenie wyniku, pytanie o ponowną gre
		
	}


}
