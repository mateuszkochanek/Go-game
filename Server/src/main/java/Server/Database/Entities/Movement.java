package Server.Database.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movement")
public class Movement {
	@Id
    @Column(name = "id") private int id;
	@Column(name = "type") private String type;
	@Column(name = "x") private int x;
	@Column(name = "y") private int y;
	@Column(name = "player") private int player;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,})
    @JoinColumn(name="id_game")
	private GoGame game;

	public Movement() {
		super();
	}

	public Movement(String type, int x, int y, int player, GoGame game) {
		super();
		this.type = type;
		if (x >= 0)
		  this.x = x;
		if (y >=0 )
		  this.y = y;
		this.player = player;
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

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public GoGame getGame() {
		return game;
	}

	public void setGame(GoGame game) {
		this.game = game;
	}
	
	
}
