package Server.ServerMessage;

public class GameSettings implements ServerMessage {
	private int size;
	private String mode; //hotSeat, Online, Multiplayer
	
	public GameSettings(int size, String mode) {
		this.size = size;
		this.mode = mode;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

}