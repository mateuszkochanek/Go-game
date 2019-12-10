package ClientApplication.GoGame;

import java.io.IOException;
import java.net.UnknownHostException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.NewGameFrame;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication{

	public static void main(String[] args) {

		try {
			Client client = new Client("localhost", 59898);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));*/
		
		while(true) {//czekac bedzie na powtórzenie gry? 
			
		}
	}


}
