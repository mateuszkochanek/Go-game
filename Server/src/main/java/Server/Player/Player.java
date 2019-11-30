package Server.Player;

import java.io.IOException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;

public interface Player extends Runnable {
    
    public ClientMessage getMessage() throws ClassNotFoundException, IOException;
    public void sendMessage(ServerMessage message) throws IOException;

}
