package Server.ServerMessage;

public class OpponentMove implements ServerMessage {
    
    private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public OpponentMove(int setX, int setY) {
		this.x = setX;
		this.y = setY;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
