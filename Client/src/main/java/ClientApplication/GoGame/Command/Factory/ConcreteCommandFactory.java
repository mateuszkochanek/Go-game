package ClientApplication.GoGame.Command.Factory;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Entities.Commands.EndGameCommand;
import ClientApplication.GoGame.Entities.Commands.MoveCommand;
import ClientApplication.GoGame.Entities.Commands.NewGameCommand;
import ClientApplication.GoGame.Entities.Commands.OpponentMoveCommand;
import ClientApplication.GoGame.Entities.Commands.SetGameSettingsCommand;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.NewGame;
import Server.ServerMessage.OpponentMove;
import Server.ServerMessage.ServerMessage;

public class ConcreteCommandFactory implements CommandFactory {

    public Command getCommand(Client client, ServerMessage message) {
        if (message instanceof GameSettings) {
            return new SetGameSettingsCommand(client, message);
        } else if (message instanceof MoveInfo) {
            return new MoveCommand(client, message);
        } else if (message instanceof OpponentMove) {
            return new OpponentMoveCommand(client, message);
        } else if (message instanceof EndGame) {
            return new EndGameCommand(client, message);
        } else if (message instanceof NewGame) {
            return new NewGameCommand(client, message);
        }
        
        return null;
    }
}
