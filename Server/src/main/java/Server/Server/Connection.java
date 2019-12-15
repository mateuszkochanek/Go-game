package Server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

public class Connection {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    
    public Connection(ServerSocket listener) {
        try {
            Socket socket = listener.accept();
            
            this.outputStream = new ObjectOutputStream(socket.getOutputStream());
            this.inputStream = new ObjectInputStream(socket.getInputStream());
            
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }

    public synchronized ClientMessage getMessage() {
        ClientMessage clientMessage = null;
        try {
            clientMessage = (ClientMessage) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        
        return clientMessage;
    }
    
    public void sendMessage(ServerMessage message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }
    
}
