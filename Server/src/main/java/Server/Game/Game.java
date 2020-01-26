package Server.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Commands.Command;
import Server.Commands.Factory.CommandFactory;
import Server.Commands.Factory.ConcreteCommandFactory;
import Server.Database.Entities.GoGame;
import Server.Player.Player;
import Server.Player.Bot;

@Component
public class Game {
  
  @Autowired
  CommandFactory commandFactory;
  
    private Player player1;
    private Player player2;
    private Player actualPlayer;
    private boolean previousPass;
    private GameLogic gameLogic;
    private boolean hotseat;
    private GoGame goGame;
    
    public Game() {
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
    
    public CommandFactory getCommandFactory() {
      return commandFactory;
    }

    public void setCommandFactory(CommandFactory commandFactory) {
      this.commandFactory = commandFactory;
    }

    public GoGame getGoGame() {
      return goGame;
    }

    public void setGoGame(GoGame goGame) {
      this.goGame = goGame;
    }

    public void setPlayer1(Player player1) {
      this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
      this.player2 = player2;
    }

    public void setActualPlayer(Player actualPlayer) {
      this.actualPlayer = actualPlayer;
    }

    public void setGameLogic(GameLogic gameLogic) {
      this.gameLogic = gameLogic;
    }
}
    
