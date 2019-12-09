package Server.ServerMessage;

public class EndGame implements ServerMessage {
    private static final long serialVersionUID = 1L;
    
    private boolean surrender;
    private int yourPoints;
    private int opponentPoints;
    
    public EndGame(boolean surrender, int yourPoints, int opponentPoints) {
        this.surrender = surrender;
        this.yourPoints = yourPoints;
        this.opponentPoints = opponentPoints;
    }

    public boolean isSurrender() {
        return this.surrender;
    }

    public int getYourPoints() {
        return this.yourPoints;
    }

    public int getOpponentPoints() {
        return this.opponentPoints;
    }

}