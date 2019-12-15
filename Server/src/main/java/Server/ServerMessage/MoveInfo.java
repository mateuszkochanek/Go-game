package Server.ServerMessage;

public class MoveInfo implements ServerMessage {
    
    private static final long serialVersionUID = 1L;
    private int player;
    private int x;
    private int y;
    private int[][] emptyPlaces;
	private boolean correctMove;
    

	public MoveInfo(int player, boolean correctMove, int x, int y, int[][] emptyPlaces) {
	    this.player = player;
	    this.x = x;
	    this.y = y;
		this.correctMove = correctMove;
		this.emptyPlaces = emptyPlaces;
	}
	
	public int getPlayer() {
	    return this.player;
	}
	
	public int getX() {
	    return this.x;
	}
	
	public int getY() {
        return this.y;
    }
	
	public int[][] getEmptyPlaces() {
	    return this.emptyPlaces;
	}

	public boolean isCorrectMove() {
		return correctMove;
	}
}
