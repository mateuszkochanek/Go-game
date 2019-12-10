package Server.Game;

public class GameLogic {
    private int[][] board;
    private int koX;
    private int koY;
    
    public GameLogic(int[][] board) {
        this.board = board;
        this.koX = -1;
        this.koY = -1;
    }
    
    public boolean checkMove(int x, int y, int player) {
        //TODO
        return false;
    }
    
    public boolean checkKo(int x, int y, int player) {
        //TODO
        return false;
    }
    
    public boolean checkEndGame(int player) {
        //TODO
        return false;
    }
    
    public void removeDeathStones(int x, int y) { //x, y - new stone's coordinate
        //TODO
    }
}
