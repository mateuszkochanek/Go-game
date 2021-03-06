package Server.Database.Service.Interfaces;

import Server.Database.Entities.GoGame;

public interface GoGameService {
  public void saveGame(GoGame goGame);
  public GoGame getGame();
  public GoGame getGameById(int id);
  public int[] getIdList();
}
