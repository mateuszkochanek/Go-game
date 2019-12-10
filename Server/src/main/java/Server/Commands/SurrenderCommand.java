package Server.Commands;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.SurrenderInfo;

public class SurrenderCommand extends Command {
    
    public SurrenderCommand(Game game, ClientMessage message, Player player) {
        super(game, message, player);
    }

	@Override
	public void executeCommand() {
	    this.game.getGameEnd().removeDeathStones();
        
        int player1Points = this.game.getGameEnd().countPoints(1);
        int player2Points = this.game.getGameEnd().countPoints(2);
        
        try {
            if (this.game.getPlayer1().equals(this.player)) {
                this.game.getPlayer1().sendMessage(new SurrenderInfo(true, player1Points, player2Points));
                this.game.getPlayer2().sendMessage(new SurrenderInfo(false, player2Points, player1Points));
            } else {
                this.game.getPlayer1().sendMessage(new SurrenderInfo(false, player1Points, player2Points));
                this.game.getPlayer2().sendMessage(new SurrenderInfo(true, player2Points, player1Points));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: play again (?)
	}

}
