package Server.Player;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.Server.Connection;
import Server.ServerMessage.ServerMessage;

public class Human implements Player {
    private Connection connection;
    private Game game;
    private int points;
    private int number;
    
    public Human(Connection connection, int number) {
        this.connection = connection;
        this.number = number;
        this.points = 0;
    }

    @Override
    public void run() {
        
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        ClientMessage clientMessage = null;
        do {
            clientMessage = this.connection.getMessage();
            this.game.getMessage(clientMessage, this);
            
        } while (true);
      
    }
    
    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        System.out.println("Human, Before send message");
        this.connection.sendMessage(message);
        System.out.println("Human, after send message");
    }

    @Override
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }
}
