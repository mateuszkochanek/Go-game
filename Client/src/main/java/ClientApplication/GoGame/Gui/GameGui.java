package ClientApplication.GoGame.Gui;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.Frame.Frame;
import ClientApplication.GoGame.Gui.Frame.GameBoard9Frame;
import ClientApplication.GoGame.Gui.Frame.NewGameFrame;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGui {//ogarnia framy i controllery
	Stage stage;
	Client client;
	Frame frame;
	
	public GameGui(Stage stage, Client client) {
		this.stage = stage;
		this.client = client;
		VBox vBox = new VBox(new Label("Waiting for server"));
		Scene scene = new Scene(vBox);
		this.stage.setScene(scene);
	}
	
	public void ShowWaitFrame() {
		this.stage.show();
	}
	
	public void CreateNewGameFrame() {
		this.stage.close();
		NewGameFrame newGameFrame = new NewGameFrame(client);
		this.stage = newGameFrame.getStage();
	}
	
	public void CreateGameBoard9Frame() {
		this.stage.close();
		this.frame = new GameBoard9Frame(client);
		this.stage = frame.getStage();	
	}

	public void doMove(int x, int y, int[][] empty, int color) {
		frame.doMove(x, y, empty, color);
	}
}
