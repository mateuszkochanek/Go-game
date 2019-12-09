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
import Server.ServerMessage.Start;

public class SetGameOptionsCommand extends Command {
    
	public SetGameOptionsCommand(Game game, ClientMessage message) {
        super(game, message);
    }

    @Override
    public void executeCommand() {
    	SetGameOptions message = (SetGameOptions) this.clientMessage;
    	
    	this.game.setBoard(message.getSize());
    	
    	if (message.getMode().contentEquals("hotseat")) {
    	    
    	    Player player2;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(player2 = new Human(this.game.getPlayer1().getSocket(), this.game, 2));
            
    	    this.game.setPlayer2(player2);
    	    
    	} else if (message.getMode().contentEquals("singleplayer")) {
    	    
    	    Player bot;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(bot = new Bot(this.game, 2));
    	    
            this.game.setPlayer2(bot);
            
    	} else if (message.getMode().contentEquals("multiplayer")) {
    	    
    	    Player player2 = game.getNewHuman();
    	    this.game.setPlayer2(player2);
    	    
    	    try {
    	        this.game.getPlayer2().sendMessage(new SentGameOptions(message.getSize(), message.getMode()));
                this.game.getPlayer1().sendMessage(new Start());
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
 
	}

}
