package ClientApplication.GoGame.Gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class NewGameFrame {
	Parent root;
	public NewGameFrame() {
		try {
			root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
