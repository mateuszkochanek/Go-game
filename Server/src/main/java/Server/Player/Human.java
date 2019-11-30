package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

public class Human implements Player {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Human(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.print("Seting input and output... ");
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Done");
            
            while(inputStream != null) {
                
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
    
    public ClientMessage getMessage() throws ClassNotFoundException, IOException {
        return (ClientMessage) inputStream.readObject();
    }
    
    public void sendMessage(ServerMessage message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }

}
