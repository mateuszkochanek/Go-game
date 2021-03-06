package ClientApplication.GoGame.Command.Factory;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Entities.Commands.EndGameCommand;
import ClientApplication.GoGame.Entities.Commands.MoveCommand;
import ClientApplication.GoGame.Entities.Commands.NewGameCommand;
import ClientApplication.GoGame.Entities.Commands.OpponentPassCommand;
import ClientApplication.GoGame.Entities.Commands.SetGameSettingsCommand;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.NewGame;
import Server.ServerMessage.OpponentPass;
import Server.ServerMessage.SentGameOptions;
import Server.ServerMessage.ServerMessage;

public class ConcreteCommandFactory implements CommandFactory {

    public Command getCommand(GameGui gameGui, ServerMessage message) {
        if (message instanceof SentGameOptions) {
            return new SetGameSettingsCommand(gameGui, message);
        } else if (message instanceof MoveInfo) {
            return new MoveCommand(gameGui, message);
        } else if (message instanceof EndGame) {
            return new EndGameCommand(gameGui, message);
        } else if (message instanceof NewGame) {
            return new NewGameCommand(gameGui, message);
        } else if (message instanceof OpponentPass) {
            return new OpponentPassCommand(gameGui, message);
        }
        
        return null;
    }
}
