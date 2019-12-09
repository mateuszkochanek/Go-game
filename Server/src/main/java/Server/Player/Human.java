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
    private Game game = null;

    public Human(Socket socket,Game game) {
        this.socket = socket;
        this.game = game;
        System.out.println("Create human");
    }

    @Override
    public void run() {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            
            while(inputStream != null) {
                ClientMessage clientMessage = (ClientMessage) inputStream.readObject();
                this.game.getMessage(clientMessage);
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

}
