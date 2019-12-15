package Server.Player;

import java.io.IOException;

import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public interface Player extends Runnable {
    
    public void sendMessage(ServerMessage message) throws IOException;
    public void addPoints(int points);
    public int getPoints();
    public int getNumber();
    public void setGame(Game game);
}
