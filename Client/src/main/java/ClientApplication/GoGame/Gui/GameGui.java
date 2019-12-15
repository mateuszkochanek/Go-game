package ClientApplication.GoGame.Gui;

import java.io.IOException;

import ClientApplication.GoGame.Command.Factory.CommandFactory;
import ClientApplication.GoGame.Command.Factory.ConcreteCommandFactory;
import ClientApplication.GoGame.Connection.Client;
import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.Commands.Command;
import ClientApplication.GoGame.Gui.Controller.Controller;
import ClientApplication.GoGame.Gui.Frame.EndGameFrame;
import ClientApplication.GoGame.Gui.Frame.Frame;
import ClientApplication.GoGame.Gui.Frame.GameBoardFrame;
import ClientApplication.GoGame.Gui.Frame.NewGameFrame;
import Server.ServerMessage.ServerMessage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGui {//ogarnia framy i controllery
	private Stage stage;
	private Client client;
	private Frame frame;
	private CommandFactory commandFactory;
	
	public GameGui(Stage stage, Client client) {
	    this.commandFactory = new ConcreteCommandFactory();
		this.stage = stage;
		this.client = client;
		VBox vBox = new VBox(new Label("Waiting for server"));
		Scene scene = new Scene(vBox);
		this.stage.setScene(scene);
	}
	
	public void getServerMessage(ServerMessage serverMessage) {
		Command command = this.commandFactory.getCommand(this, serverMessage);
	    command.executeCommand();
	}
	
	public void ShowWaitFrame() { // wywolywane w GoGameClientApplication
		this.stage.show();
	}
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public void sendMessage(ClientMessage clientMessage) {
		try {
			client.sendMessage(clientMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		client.closeConnection();
		
	}


}
