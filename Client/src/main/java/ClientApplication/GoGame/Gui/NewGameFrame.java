package ClientApplication.GoGame.Gui;

import java.io.IOException;

import ClientApplication.GoGame.GoGameClientApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameFrame extends Application {
	Parent root;
	public void startFrame() {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
			Stage stage = new Stage();
			stage.setTitle("FXML Welcome");
	        stage.setScene(new Scene(root, 300, 275));
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}