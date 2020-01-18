package Server.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id") private int id;
  @Column(name = "date") private String date;
  @Column(name = "type") private String type;
  @Column(name = "size") private int size;
  
  @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy = "game")
  private List<Movement> movements;

  public Game() {}
  
  public Game(String date, String type, int size, List<Movement> movements) {
    super();
    this.date = date;
    this.type = type;
    this.size = size;
    this.movements = movements;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<Movement> getMovements() {
    return movements;
  }

  public void setMovements(List<Movement> movements) {
    this.movements = movements;
  }
}
