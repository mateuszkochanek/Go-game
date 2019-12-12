package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public class Human implements Player {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Game game;
    private int points;

    public Human(Socket socket,Game game, ObjectInputStream ois, ObjectOutputStream ous) {
        this.inputStream = ois;
        this.outputStream = ous;
        this.socket = socket;
        this.game = game;
        this.points = 0;
        System.out.println("Create human");
    }

    @Override
    public void run() {
        try {
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
        }
      
    }
    
    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }
    
    public Socket getSocket() {
        return this.socket;
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
        return this.inputStream;
    }

    @Override
    public ObjectOutputStream getObjectOutputStream() {
        return this.outputStream;
    }
}
