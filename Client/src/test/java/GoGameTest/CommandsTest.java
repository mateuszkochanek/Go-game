package GoGameTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Entities.Commands.MoveCommand;
import ClientApplication.GoGame.Entities.Commands.OpponentPassCommand;
import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Controller.GameBoardController;
import ClientApplication.GoGame.Gui.Frame.Frame;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentPass;
import Server.ServerMessage.ServerMessage;
import javafx.stage.Stage;

//@RunWith( JfxTestRunner.class )
public class CommandsTest {
	Frame frameMock;
	GameGui gameGuiMock;
	Stage stageMock;
	
	//@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
		
	@Before
	public void beforeCommandTest() {
		this.frameMock = Mockito.mock(Frame.class);
		this.gameGuiMock = Mockito.mock(GameGui.class);
		this.stageMock = Mockito.mock(Stage.class);
		Mockito.when(gameGuiMock.getFrame()).thenReturn(frameMock);
	}
	
	@Test
	public void moveCommandTest() {
		GameBoardController controllerMock = Mockito.mock(GameBoardController.class);
		Mockito.when(frameMock.getController()).thenReturn(controllerMock);	
		ServerMessage serverMessage = new MoveInfo(0, true, 0, 0, null);
		Command command = new MoveCommand(gameGuiMock, serverMessage);
		command.executeCommand();
		Mockito.verify(controllerMock).showMove(0, 0, 0);
		Mockito.verify(controllerMock).emptyPlaces(null);
	}
	
	@Test
	public void opponentPassCommandTest() {
		GameBoardController controllerMock = Mockito.mock(GameBoardController.class);
		Mockito.when(frameMock.getController()).thenReturn(controllerMock);	
		ServerMessage serverMessage = new OpponentPass();
		Command command = new OpponentPassCommand(gameGuiMock, serverMessage);
		command.executeCommand();
		Mockito.verify(controllerMock).showOpponentPass();
	}
	
	/*@Test
	public void setGameSettingsCommandTest() {
		GameBoardController controllerMock = Mockito.mock(GameBoardController.class);
		Mockito.when(frameMock.getStage()).thenReturn(stageMock);	
		Mockito.when(gameGuiMock.getStage()).thenReturn(stageMock);	
		Mockito.doThrow().when(stageMock).show();
		Mockito.doThrow().when(stageMock).close();
		SentGameOptions serverMessage = new SentGameOptions(1, 10, null);
		Command command = new SetGameSettingsCommand(gameGuiMock, serverMessage);
		command.executeCommand();
		Mockito.verify(serverMessage).getSize();
		Mockito.verify(stageMock).show();
		Mockito.verify(gameGuiMock).getStage();
		Mockito.verify(stageMock).close();
	}
	
	@Test
	public void newGameCommandTest() {	
		ServerMessage serverMessage = new MoveInfo(0, true, 0, 0, null);
		Command command = new NewGameCommand(gameGuiMock, serverMessage);
		command.executeCommand();
		Mockito.verify(gameGuiMock).setFrame(new NewGameFrame(gameGuiMock));
		Mockito.verify(gameGuiMock).getStage().show();
	}
	
	@Test
	public void endGameCommandTest() {
		GameBoardController controllerMock = Mockito.mock(GameBoardController.class);
		Mockito.when(frameMock.getController()).thenReturn(controllerMock);	
		ServerMessage serverMessage = new MoveInfo(0, true, 0, 0, null);
		Command command = new MoveCommand(gameGuiMock, serverMessage);
		command.executeCommand();
		Mockito.verify(controllerMock).showMove(0, 0, 0);
		Mockito.verify(controllerMock).emptyPlaces(null);
	}*/
}
