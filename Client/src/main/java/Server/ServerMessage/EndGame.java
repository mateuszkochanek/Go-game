package Server.ServerMessage;

public class EndGame implements ServerMessage {
    private static final long serialVersionUID = 1L;
    
    private boolean surrender;
    private int player1Points;
    private int player2Points;
    private int playerSurrender;
    
    public EndGame(boolean surrender, int playerSurrender, int player1Points, int player2Points) {
        this.surrender = surrender;
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.playerSurrender = playerSurrender;
    }

    public boolean isSurrender() {
        return this.surrender;
    }

    public int getplayer1Points() {
        return player1Points;
    }

    public int getplayer2Points() {
        return player2Points;
    }

    public int getPlayerSurrender() {
        return playerSurrender;
    }
}