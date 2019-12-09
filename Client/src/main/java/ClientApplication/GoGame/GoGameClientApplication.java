package ClientApplication.GoGame;

import java.io.IOException;
import java.net.UnknownHostException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentMove;
import Server.ServerMessage.ServerMessage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Client client = new Client("localhost", 59898);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		
		while(true) {//czekac bedzie na powtórzenie gry? 
			
		}
	}

}
