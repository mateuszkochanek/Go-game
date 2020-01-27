package ClientApplication.GoGame.Gui.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import ClientApplication.GoGame.Gui.GameGui;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewGameFrameController extends Controller implements Initializable{
    @FXML
    private Text textLabel;
    
    @FXML
    private ToggleGroup typeGroup;

    @FXML
    private ToggleGroup sizeGroup;

    @FXML
    private Button startButton;
    
    @FXML
    private Button load;

    @FXML
    private ComboBox<Integer> comboBox;


    private int[] gameIds;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	LinkedList<Integer> oList = new LinkedList<>();
    	for(int i = 0; i<gameIds.length;i++) {
    		oList.add(new Integer(gameIds[i]));
    		
    	}
    	comboBox.getItems().addAll(oList);
    }    
    
    @FXML
    void loadChosenGame(ActionEvent event) {
    	int gameId = comboBox.getValue();
    	if(gameId != -1) {
    		System.out.println("Dziala" + gameId);
    		ClientMessage clientMessage = new SetGameOptions(0,"Load",gameId);
    		gameGui.sendMessage(clientMessage);
    	} else {
    		textLabel.setText("Nie wybrales opcji!");
    	}
    }
    
    @FXML
    void SendGameOptions(ActionEvent event) {//TODO handle exceptions better!
    	System.out.println(event.toString());
    	int size;
    	String type;
    	RadioButton selectedTypeButton = (RadioButton) typeGroup.getSelectedToggle();
    	RadioButton selectedSizeButton = (RadioButton) sizeGroup.getSelectedToggle();
    	if(selectedTypeButton != null && selectedSizeButton != null) {
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
    		gameGui.sendMessage(clientMessage);
    	} else {
    		textLabel.setText("Nie wybrales opcji!");
    	}
    }
	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}

	public int[] getGameIds() {
		return gameIds;
	}

	public void setGameIds(int[] gameIds) {
		this.gameIds = gameIds;
	}
	

}
