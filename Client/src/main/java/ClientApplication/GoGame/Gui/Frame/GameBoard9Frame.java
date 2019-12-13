package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.Controller.GameBoard9Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class GameBoard9Frame implements Frame {
	Stage stage;
	GameBoard9Controller controller;
	public GameBoard9Frame(Client client) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXMLGameBoard9.fxml"));
			Parent root = loader.load();
			this.controller = loader.<GameBoard9Controller>getController();
			this.controller.setConnection(client);
			Stage stage = new Stage();
			stage.setTitle("GoGame NewGame");
	        stage.setScene(new Scene(root,500,500));
	        this.stage = stage;
	        stage.show();
		} catch (IOException e) {
			System.out.println("GameBoard9Frame złapał błąd");
			e.printStackTrace();
		}
	}

	public Stage getStage() {
		return stage;
	}

	@Override
	public void doMove(int x, int y, int[][] empty, int color) {
		controller.showMove(x, y, color);
		controller.emptyPlaces(empty);
	}
}
