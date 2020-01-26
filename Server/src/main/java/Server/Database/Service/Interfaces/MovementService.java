package Server.Database.Service.Interfaces;

import Server.Database.Dao.Interfaces.MovementDAO;
import Server.Database.Entities.Movement;

public interface MovementService {
  public void saveMovement(Movement movement);
  public MovementDAO getMovementDAO();

  public void setMovementDAO(MovementDAO movementDAO);
}
