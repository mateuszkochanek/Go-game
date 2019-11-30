package Server.Game;

import Server.Player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private int size;
    
    public Game(Player player1, Player player2, int size) {
        System.out.printf("Create game");
        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
    }
}
