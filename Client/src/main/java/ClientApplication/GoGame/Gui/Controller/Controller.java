package ClientApplication.GoGame.Gui.Controller;

import ClientApplication.GoGame.Gui.GameGui;

public abstract class Controller {
	GameGui gameGui;
	public void setGameGui(GameGui gameGui) {
		this.gameGui = gameGui;
	}
}
