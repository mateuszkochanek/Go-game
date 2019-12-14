package Server.ServerMessage;

public class EndGame implements ServerMessage {
    private static final long serialVersionUID = 1L;
    
    private boolean surrender;
    private int player1points;
    private int player2points;
    private int playerSurrender;
    
    public EndGame(boolean surrender, int playerSurrender, int player1Points, int player2Points) {
        this.surrender = surrender;
        this.player1points = player1points;
        this.player2points = player2points;
        this.playerSurrender = playerSurrender;
    }

    public boolean isSurrender() {
        return this.surrender;
    }

    public int getPlayer1points() {
        return player1points;
    }

    public int getPlayer2points() {
        return player2points;
    }

    public int getPlayerSurrender() {
        return playerSurrender;
    }
}