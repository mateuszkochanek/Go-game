package Server.Game;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Commands.Command;
import Server.Commands.Factory.CommandFactory;
import Server.Commands.Factory.ConcreteCommandFactory;
import Server.Database.Entities.GoGame;
import Server.Player.Player;
import Server.Player.Bot;

public class Game {
    private Player player1;
    private Player player2;
    private Player actualPlayer;
    private CommandFactory commandFactory;
    private boolean previousPass;
    private GameLogic gameLogic;
    private boolean hotseat;
    private GoGame goGame;

    public Game(Player player1, Player player2, int boardSize, boolean hotseat, GoGame goGame) {
        this.player1 = player1;
        this.player2 = player2;
        this.actualPlayer = player1;
        this.goGame = goGame;
        
        this.commandFactory = new ConcreteCommandFactory();
        this.hotseat = hotseat;
        this.gameLogic = new GameLogic(boardSize);
        this.previousPass = false; 
    }

	public synchronized void getMessage(ClientMessage clientMessage, Player player) {
    	Command command = this.commandFactory.getCommand(clientMessage);
    	if (command != null)
    	    command.executeCommand(this, player, goGame);
    }
	
	public void changeActualPlayer() {
	    if (this.actualPlayer.equals(this.player1)) {
	        this.actualPlayer = this.player2;
	    } else {
	        this.actualPlayer = this.player1;
	    }
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getActualPlayer() {
		return actualPlayer;
	}
	
	public boolean isPreviousPass() {
        return this.previousPass;
    }

    public void setPreviousPass(boolean previousPass) {
        this.previousPass = previousPass;
    }
    
    public GameLogic getGameLogic() {
        return this.gameLogic;
    }

    public boolean isHotseat() {
        return this.hotseat;
    }

    public void setHotseat(boolean hotseat) {
        this.hotseat = hotseat;
    }
}
    
