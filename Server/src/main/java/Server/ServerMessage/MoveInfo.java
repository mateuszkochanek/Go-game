package Server.ServerMessage;

public class MoveInfo implements ServerMessage {
    
    private static final long serialVersionUID = 1L;
	boolean correctMove;

	public MoveInfo(boolean correctMove) {
		this.correctMove = correctMove;
	}

	public boolean isCorrectMove() {
		return correctMove;
	}
}
