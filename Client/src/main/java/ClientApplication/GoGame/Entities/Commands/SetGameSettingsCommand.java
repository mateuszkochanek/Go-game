package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.ServerMessage;

public class SetGameSettingsCommand extends Command {
    
	public SetGameSettingsCommand(Client client, ServerMessage message) {
        super(client, message);
    }

    @Override
	protected void executeCommand() {
		ClientMessage clientMessage;
		if (((GameSettings) serverMessage).getMode() == null) {
			//TODO musimy wywolac okienko z wyborem informacji, przekazac je tutaj
			//tworzenie game settings i gry
			// Game game = new Game(???)
			clientMessage = new SetGameOptions(19, "hotseat");

		} else {
			// TODO stworz grę na podstawie odebranych settingów
			// Game game = new Game(((GameSettings) serverGotMessage).getSize())?
			clientMessage = new SetGameOptions(0, null); //odeslanie ze przyjęto opcje ustawione przez drugigo gracza
		}
		try {
			client.sendMessage(clientMessage);
		} catch (IOException e) {
			System.out.println("Could not execute Move command due to sending message error.");
			//e.printStackTrace();
		} catch (NullPointerException e) {
		    System.out.println("null pointer");
		    e.printStackTrace();
		}
		
	}

}