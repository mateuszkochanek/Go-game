package Server.Database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Server.Database.Dao.Interfaces.MovementDAO;
import Server.Database.Entities.Movement;
import Server.Database.Service.Interfaces.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

  @Autowired
  private MovementDAO movementDAO;
  
  @Override
  @Transactional
  public void saveMovement(Movement movement) {
    System.out.println(movementDAO + "   ");
    this.movementDAO.saveMovement(movement);
  }

}
