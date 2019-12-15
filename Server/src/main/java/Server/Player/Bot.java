package Server.Player;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import Server.Game.Game;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentPass;
import Server.ServerMessage.ServerMessage;

public class Bot extends Player {
    private int boardSize;
    
    public Bot(int number, int boardSize) {
        this.points = 0;
        this.number = number;
        this.boardSize = boardSize;
    }

    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        if (message instanceof OpponentPass) {
            this.game.getMessage(new Pass(), this);
        } else if (message instanceof MoveInfo) {
            MoveInfo moveInfo = (MoveInfo) message;
            
            if (moveInfo.getPlayer() == 1 && moveInfo.isCorrectMove()) {
                this.doMove();
            }
        }
    }
    
    private void doMove() {
        
        for (int i = 0; i < this.boardSize; i++)
            for (int j = 0;  j< this.boardSize; j++) {
                if (this.checkOpponentNearby(i, j) && this.game.getGameLogic().checkMove(i, j, 2)) {
                    this.game.getMessage(new Move(i, j), this);
                    return;
                }
            }
        
        for (int i = 0; i < this.boardSize; i++)
            for (int j = 0;  j< this.boardSize; j++) {
                if (this.game.getGameLogic().checkMove(i, j, 2)) {
                    this.game.getMessage(new Move(i, j), this);
                    return;
                }
            }
        
        this.game.getMessage(new Pass(), this);
    }
    
    private boolean checkOpponentNearby(int x, int y) {
        if (this.game.getGameLogic().checkPlayer(x + 1, y) == 1)
            return true;
        if (this.game.getGameLogic().checkPlayer(x - 1, y) == 1)
            return true;
        if (this.game.getGameLogic().checkPlayer(x, y + 1) == 1)
            return true;
        if (this.game.getGameLogic().checkPlayer(x, y - 1) == 1)
            return true;
        
        return false;
    }

    @Override
    public void run() {}
}
