package Server.ServerMessage;

public class SentGameOptions implements ServerMessage {
   
    private static final long serialVersionUID = 1L;
    int player;
	int size;
	String mode; //hotSeat, Online, Multiplayer
	
	public SentGameOptions(int player, int size, String mode) {
	    this.player = player;
		this.size = size;
		this.mode = mode;
	}
	public int getSize() {
		return size;
	}

	public String getMode() {
		return mode;
	}

}