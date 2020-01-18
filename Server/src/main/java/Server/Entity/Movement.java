package Server.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movement")
public class Movement {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id") private int id;
  @Column(name = "type") private String type;
  @Column(name = "player") private int player;
  @Column(name = "x") private int x;
  @Column(name = "y") private int y;
  
  @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,})
  @JoinColumn(name="id_game")
  private Game game;

  public Movement() {}
  
  public Movement(String type, int player, int x, int y, Game game) {
    super();
    this.type = type;
    this.player = player;
    this.x = x;
    this.y = y;
    this.game = game;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPlayer() {
    return player;
  }

  public void setPlayer(int player) {
    this.player = player;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
