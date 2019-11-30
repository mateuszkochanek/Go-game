package Server.ClientMessages;

public class SetGameOptions implements ClientMessage{

	int size;
	String mode; //hotSeat, Online, Multiplayer
	
	public SetGameOptions(int size, String mode) {
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
