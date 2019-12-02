package Server.Game;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.Player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Player actualPlayer;
    private int size;
    
    public Game(Player player1, SetGameOptions options) {
        System.out.println("Create game");
        this.player1 = player1;
        
        //TODO handling options

    }
    
    public void getMessage(ClientMessage message) {
        System.out.println("Got it!" + message);
    }
} 
