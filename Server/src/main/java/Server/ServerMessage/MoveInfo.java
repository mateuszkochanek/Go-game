package Server.ServerMessage;

public class MoveInfo implements ServerMessage {
    
    private static final long serialVersionUID = 1L;
    int[][] emptyPlaces;
	boolean correctMove;

	public MoveInfo(boolean correctMove, int[][] emptyPlaces) {
		this.correctMove = correctMove;
		this.emptyPlaces = emptyPlaces;
	}
	
	public int[][] getEmptyPlaces() {
	    return this.emptyPlaces;
	}

	public boolean isCorrectMove() {
		return correctMove;
	}
}
