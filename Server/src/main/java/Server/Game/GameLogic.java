package Server.Game;

public class GameLogic {
    private int[][] board;
    private int size;
    private int koX;
    private int koY;
    
    /**
     * Class constructor
     * @param board
     */
    public GameLogic(int[][] board) {
        this.board = board;
        this.size = board.length;
        this.koX = -1;
        this.koY = -1;
    }
    
    /**
     * Function checks, if player can move on position (x,y).
     * If yes, put his stone in position (x,y), and now user have to run removeDeathStones function.
     * @param x coordinate of new stone
     * @param y coordinate of new stone
     * @param player integer player's value
     * @return true, if player has moved to (x,y), false otherwise
     */
    public boolean move(int x, int y, int player) {
        if (this.checkMove(x, y, player)) {
            this.board[x][y] = player; 
            return true;
        }
        
        return false;
    }
    
    /**
     * Return true, if move is possible, false otherwise
     * @param x
     * @param y
     * @param player
     * @return
     */
    public boolean checkMove(int x, int y, int player) {
        if (this.board[x][y] != 0)
            return false;
        
        if (this.checkKo(x, y))
            return false;
        
        boolean answer = this.checkBreath(x, y, player);
        this.cleanBoardAfterChecking(x, y, 0, player);
        
        if (!answer) {
            int opponent = ((player == 1) ? 2 : 1);
            answer = this.checkRemoveOtherStones(x, y, player);
            this.cleanBoardAfterChecking(x, y, 0, opponent);
        }

        if (answer) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Function remove all death stones from the board.
     * If only one stone was killed, function set ko parameters to death stone position,
     * reset ko parameters to -1 otherwise.
     * The return parameter is table with all death stones parameters
     * Size of this table give information about number of killed stones.
     * Client should change this positions to empty spaces.
     * @param x
     * @param y
     * @return table with all death stones coordinates
     */
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
    
    public int checkPlayer(int x, int y) {
        if (x < 0 || y < 0 || x >= this.size || y >= this.size)
            return -1;
        return this.board[x][y];
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
        int opponent = ((player == 1) ? 2 : 1);
        this.board[x][y] = player;
        boolean answer = false;
        
        if (x + 1 < this.size && this.board[x + 1][y] == opponent && !this.checkBreath(x + 1, y, opponent)) {
            answer = true;
        } else if (x - 1 >= 0 && this.board[x -1][y] == opponent && !this.checkBreath(x - 1, y, opponent)) {
            answer = true;
        } else if (y + 1 < this.size && this.board[x][y + 1] == opponent && !this.checkBreath(x, y + 1, opponent)) {
            answer = true;
        } else if (y - 1 >= 0 && this.board[x][y - 1] == opponent && !this.checkBreath(x, y - 1, opponent)) {
            answer = true;
        }
        
        return answer;
    }
    
    private int[][] getEmptyPlaces() {
        int amount = this.numberOfEmptyPlaces();
        if (amount == 0)
            return new int[0][0];
        
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
