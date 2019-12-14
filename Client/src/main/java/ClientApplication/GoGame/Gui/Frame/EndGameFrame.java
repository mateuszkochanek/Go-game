package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.Controller.EndGameFrameController;
import ClientApplication.GoGame.Gui.Controller.NewGameFrameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EndGameFrame {
	private Stage stage;

	public EndGameFrame(Client client,boolean isSurrender, int blackPoint, int whitePoint, int surrenderPlayer) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXMLEndGameFrame.fxml"));
			Parent root = loader.load();
			EndGameFrameController controller = loader.<EndGameFrameController>getController();
			controller.showEndGameInfo(isSurrender, blackPoint, whitePoint, surrenderPlayer);
			controller.setConnection(client);
			Stage stage = new Stage();
			stage.setTitle("GoGame EndGame");
	        stage.setScene(new Scene(root,600,400));
	        this.stage = stage;
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stage getStage() {
		return stage;
	}
	
	
}