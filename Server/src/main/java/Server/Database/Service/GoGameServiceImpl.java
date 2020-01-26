package Server.Database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Server.Database.Dao.Interfaces.GoGameDAO;
import Server.Database.Entities.GoGame;
import Server.Database.Service.Interfaces.GoGameService;

@Service
public class GoGameServiceImpl implements GoGameService {

  @Autowired
  private GoGameDAO goGameDAO;
  
  @Override
  @Transactional
  public void saveGame(GoGame goGame) {
    this.goGameDAO.saveGame(goGame);
  }

  @Override
  @Transactional
  public GoGame getGame() {
    return this.goGameDAO.getGame();
  }

}
