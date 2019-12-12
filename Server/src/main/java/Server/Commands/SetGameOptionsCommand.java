package Server.Commands;

import java.io.IOException;
import java.util.concurrent.Executors;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Game.Game;
import Server.Player.Bot;
import Server.Player.Human;
import Server.Player.Player;
import Server.ServerMessage.SentGameOptions;

public class SetGameOptionsCommand extends Command {
    
	public SetGameOptionsCommand(Game game, ClientMessage message, Player player) {
        super(game, message, player);
    }

    @Override
    public void executeCommand() {
    	SetGameOptions message = (SetGameOptions) this.clientMessage;
    	
    	this.game.setBoard(message.getSize());
    	
    	if (message.getMode().contentEquals("hotseat")) {
    	    
    	    Player player2;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(player2 = new Human(this.game.getPlayer1().getSocket(), this.game, 
                    this.game.getPlayer1().getObjectInputStream(), this.game.getPlayer1().getObjectOutputStream()));
            
    	    this.game.setPlayer2(player2);
    	    this.game.setActualPlayer(this.game.getPlayer1());
    	    try {
                this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
    	    
    	} else if (message.getMode().contentEquals("singleplayer")) {
    	    
    	    Player bot;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(bot = new Bot(this.game));
    	    
            this.game.setPlayer2(bot);
            this.game.setActualPlayer(this.game.getPlayer1());
            try {
                this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
    	} else if (message.getMode().contentEquals("multiplayer")) {
    	    
    	    Player player2 = game.getNewHuman();
    	    this.game.setPlayer2(player2);
    	    
    	    try {
    	        this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
    	        this.game.getPlayer2().sendMessage(new SentGameOptions(2, message.getSize(), message.getMode()));
    	        this.game.setActualPlayer(this.game.getPlayer1());
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
 
	}

}
