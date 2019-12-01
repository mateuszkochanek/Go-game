package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class PassCommand extends Command {
    
    public PassCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	protected void executeCommand() {
		// TODO Surrender i EndGame do implementacji!
		//Surrender też tutaj?
		//zamykanie gry, wyswietlenie wyniku, pytanie o ponowną gre
		
	}

}
