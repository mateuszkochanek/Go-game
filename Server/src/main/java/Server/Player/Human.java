package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Server.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

public class Human implements Player, Runnable {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Human(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
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
    
    public ClientMessage getMessage() throws ClassNotFoundException, IOException {
        return (ClientMessage) inputStream.readObject();
    }
    
    public void sendMessage(ServerMessage message) throws IOException {
        outputStream.writeObject(message);
    }

}
