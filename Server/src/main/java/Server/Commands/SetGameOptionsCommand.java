package Server.Commands;

import java.util.concurrent.Executors;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Game.Game;
import Server.Player.Human;
import Server.Player.Player;

public class SetGameOptionsCommand extends Command {
    
	public SetGameOptionsCommand(Game game, ClientMessage message) {
        super(game, message);
    }

    @Override
    public void executeCommand() {
    	SetGameOptions message = (SetGameOptions) this.clientMessage;
    	
    	if (message.getMode().contentEquals("hotseat")) {
    	    
    	    Player player2;
    	    var pool = Executors.newFixedThreadPool(20);
            pool.execute(player2 = new Human(this.game.getPlayer1().getSocket(), this.game));
            
    	    this.game.setPlayer2(player2);
    	}
	}

}
