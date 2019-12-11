package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameFrame {

	public NewGameFrame() {
		try {
			Parent loader = FXMLLoader.load(getClass().getResource("/FXMLNewGameFrame.fxml"));
			Stage stage = new Stage();
			stage.setTitle("FXML Welcome");
	        stage.setScene(new Scene(loader, 300, 275));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
