package ClientApplication.GoGame.Gui.Frame;

import ClientApplication.GoGame.Gui.GameGui;
import ClientApplication.GoGame.Gui.Controller.Controller;
import javafx.stage.Stage;

public abstract class Frame {
	
	protected GameGui gameGui;
	protected Controller controller;
	protected Stage stage;
	
	public Controller getController() {
		return controller;
	}
	public Stage getStage() {
		return stage;
	}	
}
