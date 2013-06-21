package yodle.juggle;

public class CoursePreference implements Comparable<CoursePreference> {

	Course c;
	int score;

	public CoursePreference(Juggler j, Course c) {
		this.c = c;
		score = dot(j, c);
	}
	
	private int dot(Juggler j, Course c) {
		int dot = j.getE() * c.getE();
		dot += j.getH() * c.getH();
		dot += j.getP() * c.getP();
		return dot;
	}
	
	@Override
	public int compareTo(CoursePreference o) {
		return o.getScore() - this.score;
	}
	
	@Override
	public String toString() {
//		C2:128
		return "C" + c.getId() + ":" + score;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
