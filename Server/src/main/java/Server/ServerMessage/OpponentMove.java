package Server.ServerMessage;

public class OpponentMove implements ServerMessage {
    
    private static final long serialVersionUID = 1L;
    int[][] emptyPlaces;
	private int x;
	private int y;
	
	public OpponentMove(int setX, int setY, int[][] emptyPlaces) {
		this.x = setX;
		this.y = setY;
		this.emptyPlaces = emptyPlaces;
	}
	
	public int[][] getEmptyPlaces() {
        return this.emptyPlaces;
    }
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
