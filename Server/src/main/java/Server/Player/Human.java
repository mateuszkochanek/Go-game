package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Connection.Connection;
import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public class Human implements Player {
    private Connection connection;
    private Game game;
    private int points;
    private int number;

    public Human(Game game, Connection connection, int number) {
        this.connection = connection;
        this.game = game;
        this.points = 0;
        this.number = number;
        System.out.println("Create human");
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
        
        
        /*try {
            if (this.inputStream == null) {
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
            }
            
            while(inputStream != null) {
                ClientMessage clientMessage = (ClientMessage) inputStream.readObject();
                this.game.getMessage(clientMessage, this);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try { 
                socket.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }*/
      
    }
    
    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        this.connection.sendMessage(message);
        /*outputStream.writeObject(message);
        outputStream.flush();*/
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
}
