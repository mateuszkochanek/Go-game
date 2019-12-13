package Server.Game;

public class GameEnd {
    private int[][] board;
    private int size;
    
    public GameEnd(int[][] board) {
        this.board = board;
        this.size = board.length;
    }

    public void removeDeathStones() {
        //TODO
    }
    
    public int countPoints(int player) {

        int points = 0;
        int opponent = ((player == 1) ? 2 : 1);
        
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.board[i][j] == 0 && !checkTerritory(i, j, opponent))
                    this.cleanBoardAfterChecking(i, j, 0, 0);
        
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.board[i][j] == -1) {
                    this.board[i][j] = 0;
                    points++;
                }

        return points;
    }
    
    private boolean checkTerritory(int x, int y, int opponent) {
        this.board[x][y] = -1;
        boolean answer = true;
        
        if (this.checkOpponent(x, y, opponent))
            answer = false;
        
            if (x + 1 < this.size && this.board[x + 1][y] == 0 && !this.checkTerritory(x + 1, y, opponent))
                answer = false;
            if (x - 1 >= 0 && this.board[x - 1][y] == 0 && !this.checkTerritory(x - 1, y, opponent))
                answer = false;
            if (y + 1 < this.size && this.board[x][y + 1] == 0 && !this.checkTerritory(x, y + 1, opponent))
                answer = false;
            if (y - 1 >= 0 && this.board[x][y - 1] == 0 && !this.checkTerritory(x, y - 1, opponent))
                answer = false;
            
        return answer;
    }
    
    private boolean checkOpponent(int x, int y, int opponent) {
        if (x + 1 < this.size && this.board[x + 1][y] == opponent)
            return true;
        if (x - 1 >= 0 && this.board[x - 1][y] == opponent)
            return true;
        if (y + 1 < this.size && this.board[x][y + 1] == opponent)
            return true;
        if (y - 1 >= 0 && this.board[x][y - 1] == opponent)
            return true;
        
        return false;
    }
    
    private void cleanBoardAfterChecking(int x, int y, int startValue, int otherValue) {
        this.cleanRecursion(x, y, otherValue);
        this.board[x][y] = startValue;
    }
    
    private void cleanRecursion(int x, int y, int value) {
        this.board[x][y] = value;
        
        if (x + 1 < this.size && this.board[x + 1][y] == -1)
            this.cleanRecursion(x + 1, y, value);
        if (x - 1 >= 0 && this.board[x - 1][y] == -1)
            this.cleanRecursion(x - 1, y, value);
        if (y + 1 < this.size && this.board[x][y + 1] == -1)
            this.cleanRecursion(x, y + 1, value);
        if (y - 1 >= 0 && this.board[x][y - 1] == -1)
            this.cleanRecursion(x, y - 1, value);
    }
    
}
