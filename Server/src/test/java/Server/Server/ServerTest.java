package Server.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Test;

import Server.ServerMessage.GameSettings;
import Server.ServerMessage.ServerMessage;

public class ServerTest {
    
    @Test
    public void serverConnectionTest() {
        
        Server server = new Server();
        
        String ip = "localhost";
        try (var socket = new Socket(ip, 59898)) {
            
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            outputStream.writeObject(new GameSettings(0, "hotseat"));
            ServerMessage newMessage = (ServerMessage) inputStream.readObject();
            
            assert(newMessage instanceof GameSettings);
            
        } catch (Exception ex) {}
    }

}
