package Server.Commands;

import java.io.IOException;

import Server.Database.Entities.GoGame;
import Server.Database.Entities.Movement;
import Server.Game.Game;
import Server.Player.Player;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OpponentPass;

public class NextCommand extends Command {

  @Override
  public void executeCommand(Game game, Player player, GoGame goGame) {
    
    Movement movement = game.getMovements()[game.getMovementsIndex()];
    game.setMovementsIndex(game.getMovementsIndex() + 1);
    
    if (movement.getType().contentEquals("move")) {
      
      int[][] emptyPlaces = game.getGameLogic().removeDeathStones(movement.getX(), movement.getY());
      game.getActualPlayer().addPoints(emptyPlaces.length);
      
      MoveInfo moveInfo = new MoveInfo(game.getActualPlayer().getNumber(), true, 
          movement.getX(), movement.getY(), emptyPlaces);
      
      try {
        game.getActualPlayer().sendMessage(moveInfo);
        game.changeActualPlayer();
        game.getActualPlayer().sendMessage(moveInfo);
        game.setPreviousPass(false);
      } catch (IOException e) {
        e.printStackTrace();
      }
      
    } else if (movement.getType().contentEquals("pass")) {
      
      if (game.isPreviousPass()) {
        game.getGameLogic().removeDeathStonesEndGame();
        
        int player1Points = game.getGameLogic().countPoints(1) + game.getPlayer1().getPoints();
        int player2Points = game.getGameLogic().countPoints(2) + game.getPlayer2().getPoints();
        
        try {
              game.getPlayer1().sendMessage(new EndGame(false, 0, player1Points, player2Points));
              game.getPlayer2().sendMessage(new EndGame(false, 0, player1Points, player2Points));
          } catch (IOException e) {
              e.printStackTrace();
          }
        
      } else {
          game.setPreviousPass(true);
          game.changeActualPlayer();
          try {
                game.getActualPlayer().sendMessage(new OpponentPass());
            } catch (IOException e) {
                e.printStackTrace();
            }
      }
      
    } else if (movement.getType().contentEquals("surrender")) {
      game.getGameLogic().removeDeathStonesEndGame();
      
      int player1Points = game.getGameLogic().countPoints(1) + game.getPlayer1().getPoints();
      int player2Points = game.getGameLogic().countPoints(2) + game.getPlayer2().getPoints();
      
      try {
          if (game.getPlayer1().equals(player)) {
              EndGame endGame = new EndGame(true, 1, player1Points, player2Points);
              game.getPlayer1().sendMessage(endGame);
              game.getPlayer2().sendMessage(endGame);
          } else {
              EndGame endGame = new EndGame(true, 2, player1Points, player2Points);
              game.getPlayer1().sendMessage(endGame);
              game.getPlayer2().sendMessage(endGame);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }

}
