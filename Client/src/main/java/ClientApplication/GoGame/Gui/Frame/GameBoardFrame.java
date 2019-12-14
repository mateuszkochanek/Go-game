package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.Controller.GameBoard9Controller;
import ClientApplication.GoGame.Gui.Controller.GameBoardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class GameBoardFrame implements Frame {
	Stage stage;
	GameBoardController controller;
	public GameBoardFrame(Client client, int size) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXMLGameBoard.fxml"));
			Parent root = loader.load();
			this.controller = loader.<GameBoardController>getController();
			this.controller.setConnection(client);
			this.controller.setBoardSize(size);
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
