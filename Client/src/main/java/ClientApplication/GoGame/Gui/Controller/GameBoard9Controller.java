package ClientApplication.GoGame.Gui.Controller;

import ClientApplication.GoGame.Connection.Client;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameBoard9Controller {
	Client client;
	
    @FXML
    private GridPane gridPane;
	
    @FXML
    void MakeMove(MouseEvent event) {
    	Node node = (Node) event.getSource();
    	System.out.println(node);
    	int y = GridPane.getRowIndex(node);
    	int x = GridPane.getColumnIndex(node);
    	System.out.println(x + " " + y);
    	
    	
    }
	
	public void setConnection(Client client) {
		this.client=client;
	}
}
