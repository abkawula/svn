package springapp.domain;

public class NineBallRack {
	
	private int id;
	private int player1Score;
	private int player2Score;
	private int deadBalls;
	private int innings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	public int getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}
	public int getDeadBalls() {
		return deadBalls;
	}
	public void setDeadBalls(int deadBalls) {
		this.deadBalls = deadBalls;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	

}
