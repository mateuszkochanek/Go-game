package Server.Commands.Factory;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Commands.Command;
import Server.Game.Game;
import Server.Player.Player;

public interface CommandFactory {

    public Command getCommand(Game game, ClientMessage message, Player player);
}
