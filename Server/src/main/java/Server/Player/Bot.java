package Server.Player;

import java.io.IOException;

import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public class Bot implements Player {
    private Game game;
    private int points;
    private int number;

    public Bot(Game game, int number) {
        this.game = game;
        this.points = 0;
        this.number = number;
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
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}
