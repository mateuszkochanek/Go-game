package ClientApplication.GoGame.Command.Factory;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.ServerMessage;

public interface CommandFactory {

    public Command getCommand(GameGui gameGui, ServerMessage message);
}
