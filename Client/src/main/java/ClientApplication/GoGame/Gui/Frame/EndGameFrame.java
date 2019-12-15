package ClientApplication.GoGame.Gui.Frame;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Controller.EndGameFrameController;
import ClientApplication.GoGame.Gui.Controller.NewGameFrameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EndGameFrame extends Frame {
	private Stage stage;

	public EndGameFrame(GameGui gameGui,boolean isSurrender, int surrenderPlayer, int blackPoint, int whitePoint) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXMLEndGameFrame.fxml"));
			Parent root = loader.load();
			EndGameFrameController controller = loader.<EndGameFrameController>getController();
			controller.showEndGameInfo(isSurrender,surrenderPlayer, blackPoint, whitePoint);
			controller.setGameGui(gameGui);
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
	
}
