package domain;

import java.io.Serializable;

public class NineBallRack implements Serializable {
	
	private int id;
	private int nineBallMatchId;
	private int player1Score;
	private int innings;
	private int deadBalls;
	private int player2Score;
	
	
	public NineBallRack(){}
	
	public NineBallRack(int id, int nineBallMatchId, int player1Score, 
			int innings, int deadBalls, int player2Score) {
		
		this.id = id;
		this.nineBallMatchId = nineBallMatchId;
		this.player1Score = player1Score;
		this.innings = innings;
		this.deadBalls = deadBalls;
		this.player2Score = player2Score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNineBallMatchId() {
		return nineBallMatchId;
	}
	public void setNineBallMatchId(int nineBallMatchId) {
		this.nineBallMatchId = nineBallMatchId;
	}
	public int getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public int getDeadBalls() {
		return deadBalls;
	}
	public void setDeadBalls(int deadBalls) {
		this.deadBalls = deadBalls;
	}
	public int getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}
	
	

}
