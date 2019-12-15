package Server.Commands.Factory;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Commands.Command;

public interface CommandFactory {

    public Command getCommand(ClientMessage message);
}
