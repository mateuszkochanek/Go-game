package ClientApplication.GoGame.Entities.Commands;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Gui.NewGameFrame;
import Server.ServerMessage.ServerMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class NewGameCommand extends Command {
    @FXML
    Button startButton;
    
    @FXML
    private ToggleGroup type;

    @FXML
    private ToggleGroup size;
    
    public NewGameCommand(Client client, ServerMessage message) {
        super(client, message);
    }

	@Override
	protected void executeCommand() {
		NewGameFrame frame = new NewGameFrame();
		frame.startFrame();
	}

    @FXML
    void SendGameSettings(ActionEvent event) {
    	 if (type.getSelectedToggle() != null && size.getSelectedToggle() != null) {
    		 System.out.println("Type: " + type.getSelectedToggle() + "   Size: " + size.getSelectedToggle());
         }
    }
    
    @FXML
    void initialize() {
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'NewGame.fxml'.";
        assert size != null : "fx:id=\"size\" was not injected: check your FXML file 'NewGame.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'NewGame.fxml'.";

    }

}

