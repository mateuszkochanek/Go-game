package Server.Game;

public class GameLogic {
    private int[][] board;
    private int size;
    private int player1Points;
    private int player2Points;
    private int koX;
    private int koY;
    
    public GameLogic(int[][] board) {
        this.board = board;
        this.size = board.length;
        this.player1Points = 0;
        this.player2Points = 0;
        this.koX = -1;
        this.koY = -1;
    }
    
    public boolean move(int x, int y, int player) {
        
        if (this.checkKo(x, y))
            return false;
        
        boolean answer = this.checkBreath(x, y, player);
        this.cleanBoardAfterChecking(x, y, 0, player);
        
        if (!answer) {
            int opponent = ((this.board[x][y] == 1) ? 2 : 1);
            answer = this.checkRemoveOtherStones(x, y, player);
            this.cleanBoardAfterChecking(x, y, 0, opponent);
        }
        
        if (answer) {
            this.board[x][y] = player;
            this.koX = x;
            this.koY = y;
            return true;
        }
        
        return false;
    }
    
    public boolean checkEndGame(int player) {
        //TODO
        return false;
    }
    
    public int[][] removeDeathStones(int x, int y) { //x, y - new stone's coordinate
        int deathStoneNumber = ((this.board[x][y] == 1) ? 2 : 1);
        
        if (x + 1 < this.size && this.board[x + 1][y] == deathStoneNumber && this.checkBreath(x + 1, y, deathStoneNumber))
            this.cleanBoardAfterChecking(x + 1, y, deathStoneNumber, deathStoneNumber);
        
        if (x - 1 >= 0 && this.board[x - 1][y] == deathStoneNumber && this.checkBreath(x - 1, y, deathStoneNumber))
            this.cleanBoardAfterChecking(x - 1, y, deathStoneNumber, deathStoneNumber);
        
        if (y + 1 < this.size && this.board[x][y + 1] == deathStoneNumber && this.checkBreath(x, y + 1, deathStoneNumber))
            this.cleanBoardAfterChecking(x, y + 1, deathStoneNumber, deathStoneNumber);
        
        if (y - 1 >= 0 && this.board[x][y - 1] == deathStoneNumber && this.checkBreath(x, y - 1, deathStoneNumber))
            this.cleanBoardAfterChecking(x, y - 1, deathStoneNumber, deathStoneNumber);
        
        int[][] emptyPlaces = this.getEmptyPlaces();
        
        if (emptyPlaces != null && emptyPlaces.length == 1) {
            this.koX = emptyPlaces[0][0];
            this.koY = emptyPlaces[0][1];
        } else {
            this.koX = -1;
            this.koY = -1;
        }
        
        this.removeAllDeathStones();
        
        return emptyPlaces;
    }
    
    private boolean checkKo(int x, int y) {
        if (this.koX == x && this.koY == y)
            return true;
        return false;
    }

    private boolean checkBreath(int x, int y, int player) {
        this.board[x][y] = -1;
        
        if (this.checkEmptyPlace(x, y))
            return true;
        
        if (x + 1 < this.size && this.board[x + 1][y] == player && this.checkBreath(x + 1, y, player))
            return true;
        if (x - 1 >= 0 && this.board[x - 1][y] == player && this.checkBreath(x - 1, y, player))
            return true;
        if (y + 1 < this.size && this.board[x][y + 1] == player && this.checkBreath(x, y + 1, player))
            return true;
        if (y - 1 >= 0 && this.board[x][y - 1] == player && this.checkBreath(x, y - 1, player))
            return true;
        
        return false;
    }
    
    private boolean checkEmptyPlace(int x, int y) {
        if (x + 1 < this.size && this.board[x + 1][y] == 0)
            return true;
        if (x - 1 >= 0 && this.board[x - 1][y] == 0)
            return true;
        if (y + 1 < this.size && this.board[x][y + 1] == 0)
            return true;
        if (y - 1 >= 0 && this.board[x][y - 1] == 0)
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
    
    private boolean checkRemoveOtherStones(int x, int y, int player) {
        int opponent = ((this.board[x][y] == 1) ? 2 : 1);
        this.board[x][y] = player;
        boolean answer = false;
        
        if (x + 1 < this.size && this.checkBreath(x + 1, y, opponent)) {
            answer = true;
        } else if (x - 1 >= 0 && this.checkBreath(x - 1, y, opponent)) {
            answer = true;
        } else if (y + 1 < this.size && this.checkBreath(x, y + 1, opponent)) {
            answer = true;
        } else if (y - 1 >= 0 && this.checkBreath(x, y - 1, opponent)) {
            answer = true;
        }
        
        return answer;
    }
    
    private int[][] getEmptyPlaces() {
        int amount = this.numberOfEmptyPlaces();
        
        if (amount == 0)
            return null;
        
        int actualAmount = 0;
        int[][] table = new int[amount][2];
        
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.board[i][j] == -1) {
                    table[actualAmount][0] = i;
                    table[actualAmount][1] = j;
                    actualAmount++;
                }
        
        return table;
    }
    
    private int numberOfEmptyPlaces() {
        int answer = 0;
        
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.board[i][j] == -1)
                    answer++;
        
        return answer;
    }
    
    private void removeAllDeathStones() {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.board[i][j] == -1)
                    this.board[i][j] = 0;
    }
}
