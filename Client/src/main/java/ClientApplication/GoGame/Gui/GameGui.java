package ClientApplication.GoGame.Gui;

import ClientApplication.GoGame.Gui.Frame.NewGameFrame;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGui {//ogarnia framy i controllery
	Stage stage;
	
	public GameGui(Stage stage) {
		this.stage = stage;
		VBox vBox = new VBox(new Label("Waiting for server"));
		Scene scene = new Scene(vBox);
		this.stage.setScene(scene);
	}
	
	public void ShowWaitFrame() {
		stage.show();
	}
	
	public void CreateNewGameFrame() {
		this.stage.close();
		NewGameFrame newGameFrame = new NewGameFrame();
	}
}
