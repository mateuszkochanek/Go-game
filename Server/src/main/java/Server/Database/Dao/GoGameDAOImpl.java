package Server.Database.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Server.Database.Dao.Interfaces.GoGameDAO;
import Server.Database.Entities.GoGame;

@Repository
public class GoGameDAOImpl implements GoGameDAO {

  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public void saveGame(GoGame goGame) {
    Session session = this.sessionFactory.getCurrentSession();
    session.saveOrUpdate(goGame);
  }
}
