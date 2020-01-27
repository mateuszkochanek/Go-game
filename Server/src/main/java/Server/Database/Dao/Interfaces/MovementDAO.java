package Server.Database.Dao.Interfaces;

import Server.Database.Entities.Movement;

public interface MovementDAO {
  public void saveMovement(Movement movement);
  public Movement[] getMovementsById(int id);
}
