package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import Server.ServerMessage.ServerMessage;

public class OpponentMoveCommand extends Command {
    
    public OpponentMoveCommand(Client client, ServerMessage message) {
        super(client, message);
    }

	@Override
	protected void executeCommand() {
		ClientMessage clientMessage;
		// TODO zupdateuj grę na podstawie informacji o ruchu przeciwnika
		// game.update(serverMessage)
		// czekamy az w gui ktos kliknie i wysylamy jego move jaki chce
		clientMessage = new Move(1, 1);
		
		try {
			client.sendMessage(clientMessage);
		} catch (IOException e) {
			System.out.println("Could not execute Move command due to sending message error.");
			//e.printStackTrace();
		}
		
	}

}
