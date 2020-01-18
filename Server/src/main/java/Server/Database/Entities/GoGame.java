package Server.Database.Entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "game")
public class GoGame {
	@Id
    @Column(name = "id") private int id;
	@Column(name = "date") private Date date;//?????????temporalValues.setSqlDate(java.sql.Date.valueOf("2017-11-15"));
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy = "game")
	List <Movement> movements;

	public GoGame() {
		super();
	}
	
	public GoGame(int id, Date date, List<Movement> movements) {
		super();
		this.id = id;
		this.date = date;
		this.movements = movements;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
}
