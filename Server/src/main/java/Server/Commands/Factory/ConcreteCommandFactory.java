package Server.Commands.Factory;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import ClientApplication.GoGame.Entities.ClientMessages.Surrender;
import Server.Commands.Command;
import Server.Commands.MoveCommand;
import Server.Commands.PassCommand;
import Server.Commands.SetGameOptionsCommand;
import Server.Commands.SurrenderCommand;
import Server.Game.Game;
import Server.Player.Player;

public class ConcreteCommandFactory implements CommandFactory {

    public Command getCommand(Game game, ClientMessage message, Player player) {
        if (message instanceof SetGameOptions) {
            return new SetGameOptionsCommand(game, message, player);
        } else if (message instanceof Move) {
            return new MoveCommand(game, message, player);
        } else if (message instanceof Surrender) {
            return new SurrenderCommand(game, message, player);
        } else if (message instanceof Pass) {
            return new PassCommand(game, message, player);
        }
        //TODO make message that is sent when no other message is recognized (null can cause nullprtexe)
        return null;
    }
}
//TODO: createInstance()