package ClientApplication.GoGame;

import java.io.IOException;
import java.net.UnknownHostException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import ClientApplication.GoGame.Gui.GameGui;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.ServerMessage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication extends Application {
	Client client;
	public static void main(String[] args) {
			launch(args);
	}
	public void init() {
		try {
			client = new Client("localhost", 59898);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GameGui gameGui = new GameGui(primaryStage,client);
		gameGui.ShowWaitFrame();
		client.setGameGui(gameGui);
		client.startConnection();
	}

	}
