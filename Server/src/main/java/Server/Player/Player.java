package Server.Player;

import java.io.IOException;
import java.net.Socket;

import Server.ServerMessage.ServerMessage;

public interface Player extends Runnable {
    
    public void sendMessage(ServerMessage message) throws IOException;
    public Socket getSocket();
}
