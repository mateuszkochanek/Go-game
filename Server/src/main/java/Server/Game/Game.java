package Server.Game;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Commands.Command;
import Server.Commands.Factory.CommandFactory;
import Server.Commands.Factory.ConcreteCommandFactory;
import Server.Player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Player actualPlayer;
    private CommandFactory commandFactory;
    private int size;
    
    public Game() {
    	this.commandFactory = new ConcreteCommandFactory();
	}

	public void getMessage(ClientMessage clientMessage) { //TODO synchronized?
    	Command command = this.commandFactory.getCommand(this, clientMessage);
    	command.executeCommand();
    }

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getActualPlayer() {
		return actualPlayer;
	}

	public void setActualPlayer(Player actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    
    
}
