package ClientApplication.GoGame.Command.Factory;

import Server.ServerMessage.EndGame;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OponentMove;
import Server.ServerMessage.ServerMessage;

public class ConcreteCommandFactory implements CommandFactory {
    //TODO import command package and uncomment
    /*public Command getCommand(ServerMessage message) {
        if (message instanceof GameSettings) {
            return new GameSettingsCommand();
        } else if (message instanceof Move) {
            return new MoveCommand();
        } else if (message instanceof OponentMove) {
            return new OponentMoveCommand();
        } else if (message instanceof EndGame) {
            return new EndGameCommand();
        }
    }*/
}
