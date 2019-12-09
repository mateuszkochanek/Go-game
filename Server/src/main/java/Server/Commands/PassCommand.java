package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;

public class PassCommand extends Command {
    
    public PassCommand(Game game, ClientMessage message) {
        super(game, message);
    }

	@Override
	public void executeCommand() {
		// TODO Surrender i EndGame do implementacji!
		//Surrender też tutaj?
		//zamykanie gry, wyswietlenie wyniku, pytanie o ponowną gre
		
	    /**
	     * TODO:
	     * check game.previousPass
	     * true
	     *     new EndGame
	     * false
	     *     game.previousPass = true
	     *     change actual player
	     *     send info to actual player
	     */    
	    
	}

}
