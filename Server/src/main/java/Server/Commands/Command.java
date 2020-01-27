package Server.Commands;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Database.Entities.GoGame;
import Server.Game.Game;
import Server.Player.Player;

public abstract class Command {
  
	protected ClientMessage clientMessage;
	
	protected Command() {}
	
	public abstract void executeCommand(Game game, Player player, GoGame goGame);
	
	public ClientMessage getClientMessage() {
    return clientMessage;
  }

  public void setClientMessage(ClientMessage clientMessage) {
    this.clientMessage = clientMessage;
  }
}
