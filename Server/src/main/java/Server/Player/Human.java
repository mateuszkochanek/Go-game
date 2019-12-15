package Server.Player;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Server.Connection;
import Server.ServerMessage.ServerMessage;

public class Human extends Player {
    private Connection connection;
    
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
            
        } while (clientMessage != null);
      
    }
    
    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        this.connection.sendMessage(message);
    }
    
    public Connection getConnection() {
        return this.connection;
    }
}
