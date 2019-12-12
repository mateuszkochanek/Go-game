package ClientApplication.GoGame.Gui.Controller;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewGameFrameController {
	Client client;
	
    @FXML
    private Text textLabel;
    
    @FXML
    private ToggleGroup typeGroup;

    @FXML
    private ToggleGroup sizeGroup;

    @FXML
    private Button startButton;

    @FXML
    void SendGameOptions(ActionEvent event) {//TODO handle exceptions better!
    	int size;
    	String type;
    	RadioButton selectedTypeButton = (RadioButton) typeGroup.getSelectedToggle();
    	RadioButton selectedSizeButton = (RadioButton) sizeGroup.getSelectedToggle();
    	if(selectedTypeButton.getText() != null && selectedSizeButton.getText() != null) {
    		type = selectedTypeButton.getText();
    		if(selectedSizeButton.getText().equals("9x9")) {
    			size = 9;			
    		} else if(selectedSizeButton.getText().equals("13x13")) {
    			size = 13;	
    		} else if(selectedSizeButton.getText().equals("19x19")) {
    			size = 19;	
    		} else {
    			System.out.println("Size się nei ustawił w NewGame Frame > SendGameOptions.");
    			size=0;
    		}
    		ClientMessage clientMessage = new SetGameOptions(size,type);
    		try {
				client.sendMessage(clientMessage);
			} catch (IOException e) {
				System.out.println("W SendGameOptions send message nie zadzialalo jak powinno.");
				e.printStackTrace();
			}
    	} else {
    		textLabel.setText("Nie wybrales opcji!");
    	}
    }

	public void setConnection(Client client) {
		this.client=client;
	}
}
