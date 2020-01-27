package ClientApplication.GoGame.Gui.Controller;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Next;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.Surrender;
import ClientApplication.GoGame.Gui.GameGui;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GameBoardController extends Controller {
    @FXML
    private GridPane gridPane;
    
    @FXML
    private Text pass;
	
    @FXML
    void OnNextAction(ActionEvent event) {
    	hideOpponentPass();
    	ClientMessage clientMessage = new Next();
    	gameGui.sendMessage(clientMessage);
    }
    
    @FXML
    void MakeMove(MouseEvent event) {
    	hideOpponentPass();
    	Node node = (Node) event.getSource();
    	int x = GridPane.getRowIndex(node);
    	int y = GridPane.getColumnIndex(node);
    	ClientMessage clientMessage = new Move(x,y);
    	System.out.println(x + " " + y);
    	gameGui.sendMessage(clientMessage); 	
    }

    @FXML
    void OnPassAction(ActionEvent event) {
    	hideOpponentPass();
    	ClientMessage clientMessage = new Pass();
    	gameGui.sendMessage(clientMessage); 
    }

    @FXML
    void OnSurrenderAction(ActionEvent event) {
    	hideOpponentPass();
    	ClientMessage clientMessage = new Surrender();
    	gameGui.sendMessage(clientMessage);  
    }
    
    public void showMove(int x, int y, int color) {
    	Node node = findNode(x,y);
		if(node != null) {
			if(color == 1)
				((Circle) node).setFill(javafx.scene.paint.Color.BLACK);
			else if(color == 2)
				((Circle) node).setFill(javafx.scene.paint.Color.WHITE);
			else
				System.out.println("Niepoprawny kolor gracza ");
		}
	}
    public void emptyPlaces(int[][] empty) {
    	Node nodeFound = null;
    	for (int i = 0; i<empty.length ; i++) {
    		nodeFound = null;
    		nodeFound = findNode(empty[i][0], empty[i][1]);
    		if(nodeFound != null)
    			((Circle) nodeFound).setFill(javafx.scene.paint.Color.TRANSPARENT);
    	}
	}
	
    public Node findNode(int x, int y) {
    	Node nodeFound = null;
    	ObservableList<Node> children = gridPane.getChildren();
    	for (Node node : children) {
            if(GridPane.getRowIndex(node) == x && GridPane.getColumnIndex(node) == y) {
            	nodeFound = node;
        		return nodeFound;
            }
        }
		return nodeFound;
    }

	public void showOpponentPass() {
		pass.setText("Your opponent passed.");
	}
	
	public void hideOpponentPass() {
		pass.setText("");
	}
	
	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}
}
