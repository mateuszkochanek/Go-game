package ClientApplication.GoGame.Gui.Controller;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.GameGui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndGameFrameController extends Controller {
	
    @FXML
    private Text gameStatus;

    @FXML
    private Text blackPoints;

    @FXML
    private Text whitePoints;
    
    @FXML
    private Button closeButton;
    
    @FXML
    void endGame(ActionEvent event) {
    	Stage stage = (Stage) closeButton.getScene().getWindow();
    	gameGui.closeConnection();
        stage.close();
    }

	public void showEndGameInfo(boolean isSurrender, int blackPoint, int whitePoint, int surrenderPlayer) {
		if(isSurrender) {
			if(surrenderPlayer == 1) {
				gameStatus.setText("Gracz czarny się poddał.");
			} else {
				gameStatus.setText("Gracz biały się poddał.");
			}
		} else {
			if(blackPoint > whitePoint)
				gameStatus.setText("Gracz czarny wygrał.");
			else if(blackPoint < whitePoint)
				gameStatus.setText("Gracz biały wygrał.");
			else
				gameStatus.setText("Remis");
		}
		blackPoints.setText("Gracz czarny miał:" + blackPoint + " punktów.");
		whitePoints.setText("Gracz biały miał:" + whitePoint + " punktów.");	
	}

	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}


}
