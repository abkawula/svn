package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class NineBallMatch implements Serializable {
	
	private int id;
	private int player1Id;
	private int player1Rank;
	private int player2Id;
	private int player2Rank;
	private List<NineBallRack> nineBallRacks;
	private Timestamp date;
	
	
	public int getPlayer1Id() {
		return player1Id;
	}
	public void setPlayer1Id(int player1Id) {
		this.player1Id = player1Id;
	}
	public int getPlayer2Id() {
		return player2Id;
	}
	public void setPlayer2Id(int player2Id) {
		this.player2Id = player2Id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayer1Rank() {
		return player1Rank;
	}
	public void setPlayer1Rank(int player1Rank) {
		this.player1Rank = player1Rank;
	}
	public int getPlayer2Rank() {
		return player2Rank;
	}
	public void setPlayer2Rank(int player2Rank) {
		this.player2Rank = player2Rank;
	}
	public List<NineBallRack> getNineBallRacks() {
		return nineBallRacks;
	}
	public void setNineBallRacks(List<NineBallRack> nineBallRacks) {
		this.nineBallRacks = nineBallRacks;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	

}
