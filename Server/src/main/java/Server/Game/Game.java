package Server.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Commands.Command;
import Server.Commands.Factory.CommandFactory;
import Server.Commands.Factory.ConcreteCommandFactory;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.NewGame;

public class Game {
    private ServerSocket listener;
    private Human player1;
    private Player player2;
    private Player actualPlayer;
    private CommandFactory commandFactory;
    private int[][] board; // 0 nothing, 1 first player, 2 second player TODO: ko(?)
    private int size;
    private boolean previousPass;
    private GameLogic gameLogic;
    private GameEnd gameEnd;

    public Game() {
    	this.commandFactory = new ConcreteCommandFactory();
    	this.previousPass = false;
    	
    	try {
            listener = new ServerSocket(59898);
            this.setPlayer1(getNewHuman());
            
            TimeUnit.SECONDS.sleep(1);
            player1.sendMessage(new NewGame());
            this.setActualPlayer(this.player1);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}

	public void getMessage(ClientMessage clientMessage, Player player) { //TODO synchronized?
    	Command command = this.commandFactory.getCommand(this, clientMessage, player);
    	command.executeCommand();
    }
	
	public void setBoard(int size) {
	    this.size = size;
	    this.board = new int[size][size];
	    
	    this.gameLogic = new GameLogic(this.board);
        this.gameEnd = new GameEnd(this.board);
	}
	
	public Human getNewHuman() {
	    Human human;
	    try {
            Socket socket = listener.accept();
            var pool = Executors.newFixedThreadPool(20);
            pool.execute(human = new Human(socket, this, null, null));
            
            return human;
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	    return null;
	}
	
	public void changeActualPlayer() {
	    if (this.actualPlayer.equals(this.player1)) {
	        this.actualPlayer = this.player2;
	    } else {
	        this.actualPlayer = this.player1;
	    }
	}
	
	public Human getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(Human player) {
	    this.player1 = player;
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
	
	public boolean isPreviousPass() {
        return this.previousPass;
    }

    public void setPreviousPass(boolean previousPass) {
        this.previousPass = previousPass;
    }
    
    public GameLogic getGameLogic() {
        return this.gameLogic;
    }
    
    public GameEnd getGameEnd() {
        return this.gameEnd;
    }
}
    
