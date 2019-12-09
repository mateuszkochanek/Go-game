package Server.Player;

import java.io.IOException;
import java.net.Socket;

import Server.Game.Game;
import Server.ServerMessage.ServerMessage;

public class Bot implements Player {
    private Game game;

    public Bot(Game game) {
        this.game = game;
    }

    @Override
    public void sendMessage(ServerMessage message) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Socket getSocket() {
        return null;
    }

}
