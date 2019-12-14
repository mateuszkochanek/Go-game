package Server.Commands;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    	    this.game.setHotseat(true);
    	    
    	    Human player2;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(player2 = new Human(this.game, this.game.getPlayer1().getConnection(), 2));
            
    	    this.game.setPlayer2(player2);
    	    try {
                this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
    	    
    	} else if (message.getMode().contentEquals("singleplayer")) {
    	    
    	    Player bot;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(bot = new Bot(this.game, 2));
    	    
            this.game.setPlayer2(bot);
            try {
                this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
    	} else if (message.getMode().contentEquals("multiplayer")) {
    	    Player player2 = game.getNewHuman(2);
    	    
    	    this.game.setPlayer2(player2);
    	    
    	    try {
    	        this.game.getPlayer1().sendMessage(new SentGameOptions(1, message.getSize(), message.getMode()));
    	        this.game.getPlayer2().sendMessage(new SentGameOptions(2, message.getSize(), message.getMode()));
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
 
	}

}
