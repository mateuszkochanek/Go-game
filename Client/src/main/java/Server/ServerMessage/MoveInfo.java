package Server.ServerMessage;

public class MoveInfo implements ServerMessage {

	boolean correctMove;
	public MoveInfo(boolean correctMove) {
		this.correctMove = correctMove;
	}

	public boolean isCorrectMove() {
		return correctMove;
	}

	public void setCorrectMove(boolean correctMove) {
		this.correctMove = correctMove;
	}
}
