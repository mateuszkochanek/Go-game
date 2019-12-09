module Client {
	exports ClientApplication.GoGame.Command.Factory;
	exports ClientApplication.GoGame.Connection;
	exports Server.ServerMessage;
	exports ClientApplication.GoGame.Entities.Commands;
	exports ClientApplication.GoGame.Gui;
	exports ClientApplication.GoGame;
	exports ClientApplication.GoGame.Entities.ClientMessages;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}