package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Server.ServerMessage.ServerMessage;

public interface Player extends Runnable {
    
    public void sendMessage(ServerMessage message) throws IOException;
    public void addPoints(int points);
    public int getPoints();
}
