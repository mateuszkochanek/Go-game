package Server.Database.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Server.Database.Dao.Interfaces.MovementDAO;
import Server.Database.Entities.Movement;

@Repository("movementDAO")
public class MovementDAOImpl implements MovementDAO {

  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public void saveMovement(Movement movement) {
    Session session = this.sessionFactory.getCurrentSession();
    session.saveOrUpdate(movement);
  }
}
