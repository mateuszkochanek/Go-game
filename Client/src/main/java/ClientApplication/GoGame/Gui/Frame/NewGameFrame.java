package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.Controller.NewGameFrameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewGameFrame {

	public NewGameFrame(Client client) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXMLNewGameFrame.fxml"));
			Parent root = loader.load();
			NewGameFrameController controller = loader.<NewGameFrameController>getController();
			controller.setConnection(client);
			Stage stage = new Stage();
			stage.setTitle("GoGame NewGame");
	        stage.setScene(new Scene(root,500,500));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
