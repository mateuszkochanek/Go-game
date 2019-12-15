package Server.Commands.Factory;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.Surrender;
import Server.Commands.Command;
import Server.Commands.MoveCommand;
import Server.Commands.PassCommand;
import Server.Commands.SurrenderCommand;

public class ConcreteCommandFactory implements CommandFactory {

    public Command getCommand(ClientMessage message) {
        
        if (message instanceof Move) {
            return new MoveCommand(message);
        } else if (message instanceof Surrender) {
            return new SurrenderCommand(message);
        } else if (message instanceof Pass) {
            return new PassCommand(message);
        }
        
        return null;
    }
}