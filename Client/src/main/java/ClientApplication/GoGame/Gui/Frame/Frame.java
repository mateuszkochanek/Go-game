package ClientApplication.GoGame.Gui.Frame;

import javafx.stage.Stage;

public interface Frame {

	Stage getStage();

	void doMove(int x, int y, int[][] empty, int color);

	void showOponentPass();
}
