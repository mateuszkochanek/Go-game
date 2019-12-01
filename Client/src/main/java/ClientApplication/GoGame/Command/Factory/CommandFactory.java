package ClientApplication.GoGame.Command.Factory;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.Commands.Command;
import Server.ServerMessage.ServerMessage;

public interface CommandFactory {

    public Command getCommand(Client client, ServerMessage message);
}
