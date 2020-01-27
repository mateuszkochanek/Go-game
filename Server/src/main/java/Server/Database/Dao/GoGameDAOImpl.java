package Server.Database.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

  @Override
  public GoGame getGame() {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("FROM GoGame WHERE id = (SELECT max(id) FROM GoGame)");
    List<GoGame> goGame = query.list();
    return goGame.get(0);
  }
}
