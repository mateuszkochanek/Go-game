package Server.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Server.ServerMessage.GameSettings;
import Server.ServerMessage.ServerMessage;

public class Human implements Player, Runnable {
    private Socket socket;

    public Human(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Connected: " + socket);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            ServerMessage newMessage = (ServerMessage) inputStream.readObject();
            
            outputStream.writeObject(newMessage);
        } catch (Exception e) {
            System.out.println("Error:" + socket);
        } finally {
            try { 
                socket.close();
            } catch (IOException e) {}
            System.out.println("Closed: " + socket);
        }
        
    }

}
