package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import Server.ServerMessage.ServerMessage;

public class EndGameCommand extends Command {
    
    public EndGameCommand(Client client, ServerMessage message) {
        super(client, message);
    }

	@Override
	protected void executeCommand() {
		// TODO Surrender i EndGame do implementacji!
		//Surrender też tutaj?
		//zamykanie gry, wyswietlenie wyniku, pytanie o ponowną gre
		
	}

}
