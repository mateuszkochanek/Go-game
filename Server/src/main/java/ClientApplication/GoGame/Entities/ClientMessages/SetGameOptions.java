package ClientApplication.GoGame.Entities.ClientMessages;

public class SetGameOptions implements ClientMessage{

	private static final long serialVersionUID = 1L;
	int size;
	String mode; //hotSeat, Online, Multiplayer
	int gameId;
	
	public SetGameOptions(int size, String mode, int gameId) {
		this.size = size;
		this.mode = mode;
		this.gameId = gameId;
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
  public int getGameId() {
    return gameId;
  }
  public void setGameId(int gameId) {
    this.gameId = gameId;
  }
}
