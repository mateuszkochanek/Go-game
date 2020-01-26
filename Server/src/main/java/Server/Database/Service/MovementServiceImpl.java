package Server.Database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Server.Database.Dao.Interfaces.MovementDAO;
import Server.Database.Entities.Movement;
import Server.Database.Service.Interfaces.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

  private MovementDAO movementDAO;
  
  @Autowired
  public MovementServiceImpl(MovementDAO movementDAO){
    this.movementDAO = movementDAO;
  } 
  
  @Override
  @Transactional
  public void saveMovement(Movement movement) {
    this.movementDAO.saveMovement(movement);
  }

  public MovementDAO getMovementDAO() {
    return movementDAO;
  }

  public void setMovementDAO(MovementDAO movementDAO) {
    this.movementDAO = movementDAO;
  }

  
}
