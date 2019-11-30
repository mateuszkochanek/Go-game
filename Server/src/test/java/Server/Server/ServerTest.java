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
        
        //verify(server).createServer;
        
        String ip = "localhost";
        try (var socket = new Socket(ip, 59898)) {
            
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            ServerMessage newMessage = (ServerMessage) inputStream.readObject();
            assert(newMessage instanceof GameSettings);
            
        } catch (Exception ex) {}
    }

}
