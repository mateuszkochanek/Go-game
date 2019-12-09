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
	}

    @FXML
    void SendGameSettings(ActionEvent event) {
    	 if (type.getSelectedToggle() != null && size.getSelectedToggle() != null) {
    		 System.out.println("Type: " + type.getSelectedToggle() + "   Size: " + size.getSelectedToggle());
         }
    }

}

