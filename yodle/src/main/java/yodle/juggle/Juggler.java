package yodle.juggle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Juggler {
	
//	J J0 H:3 E:9 P:2 C2,C0,C1
	private static final Pattern pattern = Pattern.compile("J J(\\d+) H:(\\d+) E:(\\d+) P:(\\d+) (C.*)");
	
	private int id,h,e,p;
	private List<CoursePreference> prefs = new ArrayList<CoursePreference>();
	
	public Juggler(String s, List<Course> courses) {
		Matcher m = pattern.matcher(s);
		if (m.matches()) {
			this.id = Integer.parseInt(m.group(1));
			this.h = Integer.parseInt(m.group(2));
			this.e = Integer.parseInt(m.group(3));
			this.p = Integer.parseInt(m.group(4));
			
			String[] courseString = m.group(5).replaceAll("C", "").trim().split(",");
			for (String course : courseString) {
				Course c = courses.get(Integer.parseInt(course)); 
				prefs.add(new CoursePreference(this, c));
			}
			
		} else {
			throw new RuntimeException(s + " is not a juggler");
		}
		
	}
	
//	public void removeCourse(Course course) {
//		for (CoursePreference pref : prefs) {
//			if (pref.getC() == course) {
//				prefs.remove(pref);
//				return;
//			}
//		}
//	}
	
	public int getScore(Course course) {
		for (CoursePreference pref : prefs) {
			if (pref.getC() == course) {
				return pref.getScore();
			}
		}
		throw new IllegalArgumentException("Juggler \n " + this + " doesn't have Course \n" + course);
	}
	
	public void chooseCourse(Course course) {
		for (CoursePreference pref : prefs) {
			if (pref.getC() != course && pref.getC().addJuggler(this)) {
				return;
			}
		}
		
		throw new IllegalArgumentException("Juggler: \n" + this + "\n can't find a course");
	}
	
	@Override
	public String toString() {
//		J6 C2:128 C1:31 C0:188
		return "J" + id + " " + StringUtils.join(prefs, " ");
	}

	public int getId() {
		return id;
	}

	public int getH() {
		return h;
	}

	public int getE() {
		return e;
	}

	public int getP() {
		return p;
	}

	public List<CoursePreference> getPrefs() {
		return prefs;
	}
	
	
	
}
