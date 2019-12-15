package GoGameTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import ClientApplication.GoGame.Command.Factory.CommandFactory;
import ClientApplication.GoGame.Command.Factory.ConcreteCommandFactory;
import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
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
import javafx.stage.Stage;

public class CommandFactoryTest {
	
	@Mock
	GameGui gameGuiMock;
	
	
	@Test
    public void moveInfoMessageTest () {
		CommandFactory commandFactory = new ConcreteCommandFactory();
		ServerMessage serverMessage = new MoveInfo(0,false,0,0, null);
		Command command = commandFactory.getCommand(gameGuiMock, serverMessage);
		assertTrue(command instanceof MoveCommand);
    }
	
	@Test
    public void newGameMessageTest () {
		CommandFactory commandFactory = new ConcreteCommandFactory();
		ServerMessage serverMessage = new NewGame();
		Command command = commandFactory.getCommand(gameGuiMock, serverMessage);
		assertTrue(command instanceof NewGameCommand);
    }
	
	@Test
    public void opponentPassMessageTest () {
		CommandFactory commandFactory = new ConcreteCommandFactory();
		ServerMessage serverMessage = new OpponentPass();
		Command command = commandFactory.getCommand(gameGuiMock, serverMessage);
		assertTrue(command instanceof OpponentPassCommand);
    }
	
	@Test
    public void optionsMessageTest () {
		CommandFactory commandFactory = new ConcreteCommandFactory();
		ServerMessage serverMessage = new SentGameOptions(0, 0, null);
		Command command = commandFactory.getCommand(gameGuiMock, serverMessage);
		assertTrue(command instanceof SetGameSettingsCommand);
    }
	
	@Test
    public void endGameMessageTest () {
		CommandFactory commandFactory = new ConcreteCommandFactory();
		ServerMessage serverMessage = new EndGame(false, 0, 0, 0);
		Command command = commandFactory.getCommand(gameGuiMock, serverMessage);
		assertTrue(command instanceof EndGameCommand);
    }
}
