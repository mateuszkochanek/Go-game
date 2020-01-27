package Server.Database.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

  @Override
  public Movement[] getMovementsById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("FROM Movement WHERE id_game = :id");
    query.setParameter("id", id);
    
    List<Movement> idList = query.list();
    
    Movement[] movements = new Movement[idList.size()];
    
    for (int i = 0; i < idList.size(); i++)
      movements[i] = idList.get(i);
    
    return movements;
  }
}
