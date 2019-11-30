package Server.Player;

import java.io.IOException;

import Server.ServerMessage.ServerMessage;

public interface Player extends Runnable {
    
    public void sendMessage(ServerMessage message) throws IOException;

}
