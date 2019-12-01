package ClientApplication.GoGame.Entities.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import Server.ServerMessage.MoveInfo;

public class MoveCommand extends Command {

	@Override
	protected void executeCommand() {
		ClientMessage clientMessage;
		if (((MoveInfo) serverMessage).isCorrectMove()) {
			// TODO zupdateuj grę na podstawie informacji o swoim ruchu
			// TODO informacja że zakończyłeś turę, żeby przeciwnik zaczal swoja i zaktualizowal board
			clientMessage = new Pass();
		} else {
			//wykonaj inny move
			clientMessage = new Move(1, 2);
		}
		
		try {
			client.sendMessage(clientMessage);
		} catch (IOException e) {
			System.out.println("Could not execute Move command due to sending message error.");
			//e.printStackTrace();
		}
	}

}
