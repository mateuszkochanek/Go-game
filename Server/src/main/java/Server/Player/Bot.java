package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public class Bot implements Player {
    private Game game;
    private int points;

    public Bot(Game game) {
        this.game = game;
        this.points = 0;
    }

    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Socket getSocket() {
        return null;
    }

    @Override
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public ObjectInputStream getObjectInputStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ObjectOutputStream getObjectOutputStream() {
        // TODO Auto-generated method stub
        return null;
    }
}
