package Server.Database.Dao.Interfaces;

import Server.Database.Entities.GoGame;

public interface GoGameDAO {
  public void saveGame(GoGame goGame);
  public GoGame getGame();
  public int[] getIdList();
}
