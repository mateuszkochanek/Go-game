package ClientApplication.GoGame.Gui.Controller;

import java.io.IOException;

import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class GameBoardController {
	Client client;
	
    @FXML
    private GridPane gridPane;
	
    @FXML
    void MakeMove(MouseEvent event) {
    	Node node = (Node) event.getSource();
    	int y = GridPane.getRowIndex(node);
    	int x = GridPane.getColumnIndex(node);
    	ClientMessage clientMessage = new Move(x,y);
    	System.out.println(x + " " + y);
    	try {
			client.sendMessage(clientMessage);
		} catch (IOException e) {
			System.out.println("W Make Move send message nie zadzialalo jak powinno.");
			e.printStackTrace();
		}   	
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
            if(GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
            	nodeFound = node;
        		return nodeFound;
            }
        }
		return nodeFound;
    }
    
	public void setConnection(Client client) {
		this.client=client;
	}
}
