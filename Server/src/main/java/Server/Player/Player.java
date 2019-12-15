package Server.Player;

import java.io.IOException;

import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public abstract class Player implements Runnable {
    protected Game game;
    protected int points;
    protected int number;
    
    public abstract void sendMessage(ServerMessage message) throws IOException;
    
    public void addPoints(int points) {
        this.points += points;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
}
