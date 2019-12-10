package Server.ServerMessage;

public class SurrenderInfo implements ServerMessage {
    private static final long serialVersionUID = 1L;
    
    private boolean yourSurrender;
    private int yourPoints;
    private int opponentPoints;
    
    public SurrenderInfo(boolean yourSurrender, int yourPoints, int opponentPoints) {
        this.yourSurrender = yourSurrender;
        this.yourPoints = yourPoints;
        this.opponentPoints = opponentPoints;
    }

    public boolean isSurrender() {
        return this.yourSurrender;
    }

    public int getYourPoints() {
        return this.yourPoints;
    }

    public int getOpponentPoints() {
        return this.opponentPoints;
    }

}
