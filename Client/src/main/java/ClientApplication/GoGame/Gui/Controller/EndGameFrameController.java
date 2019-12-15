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

	public void showEndGameInfo(boolean isSurrender, int surrenderPlayer, int blackPoint, int whitePoint) {
		if(isSurrender) {
			if(surrenderPlayer == 1) {
				gameStatus.setText("Black player surrendered.");
			} else {
				gameStatus.setText("White player surrendered.");
			}
		} else {
			if(blackPoint > whitePoint)
				gameStatus.setText("Black player won.");
			else if(blackPoint < whitePoint)
				gameStatus.setText("White player won.");
			else
				gameStatus.setText("It's a Draw.");
		}
		blackPoints.setText("Black player has: " + blackPoint + " points.");
		whitePoints.setText("White player has: " + whitePoint + " points.");	
	}

	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}


}
