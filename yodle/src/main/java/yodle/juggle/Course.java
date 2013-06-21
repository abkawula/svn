package yodle.juggle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;



public class Course {

//	C C0 H:7 E:7 P:10
	private static final Pattern pattern = Pattern.compile("C C(\\d+) H:(\\d+) E:(\\d+) P:(\\d+)");
	private static int maxSize = 0;
	
	public Course (String s) {
		Matcher m = pattern.matcher(s.trim());
		if (m.matches()) {
			this.id = Integer.parseInt(m.group(1));
			this.h = Integer.parseInt(m.group(2));
			this.e = Integer.parseInt(m.group(3));
			this.p = Integer.parseInt(m.group(4));
		} else {
			throw new RuntimeException(s + " is not a course");
		}
	}
	
	private int id,h,e,p;
	private List<Juggler> jugglers = new ArrayList<Juggler>();
	
	public boolean addJuggler(Juggler j) {
		if (jugglers.contains(j)) {
			//This shouldn't happen
			return true;
		}
		
		if (jugglers.size() < maxSize) {
			System.out.println("Juggler id = " + j.getId() + " assigned to course id = " + this.id);
			this.jugglers.add(j);
			sortJugglers();
			return true;
		} 
		
		Juggler worstJuggler = jugglers.get(jugglers.size() - 1);
		if(j.getScore(this) < worstJuggler.getScore(this)) {
			System.out.println("Juggler id = " + j.getId() + " score(" + j.getScore(this) + ") denied from course id = " + this.id);
			return false;
		} else {
			// Here's the moment.  This course is full, but we've got someone who wants in... 
			// and he looks like a good fit.  Let's give the new guy a chance and send someone else out
			System.out.println("Juggler id = " + worstJuggler.getId() + " score(" + worstJuggler.getScore(this) + ") removed from course id = " + this.id);
			jugglers.remove(worstJuggler);
			
			System.out.println("Juggler id = " + j.getId() + " score(" + j.getScore(this) + ") assigned to course id = " + this.id);
			jugglers.add(j);
			
			worstJuggler.chooseCourse(this);
			sortJugglers();
			return true;
		}
	}
	
	private void sortJugglers() {
		Collections.sort(jugglers, new JugglerComparator(this));
	}
	
	private static class JugglerComparator implements Comparator<Juggler> {

		private Course course;
		private JugglerComparator(Course course) {
			this.course = course;
		}
		
		@Override
		public int compare(Juggler o1, Juggler o2) {
			return o2.getScore(course) - o1.getScore(course);
		}
		
	}
	
	
	@Override
	public String toString() {
//		C2 J6 C2:128 C1:31 C0:188, J3 C2:120 C0:171 C1:31, J10 C0:120 C2:86 C1:21, J0 C2:83 C0:104 C1:17
		return "C" + id + " " + StringUtils.join(jugglers, ", ");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}
	
	public static void setMaxSize(int max) {
		maxSize = max;
	}
	
}
