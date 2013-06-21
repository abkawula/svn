package yodle.juggle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;



public class Course {

//	C C0 H:7 E:7 P:10
	private static final Pattern pattern = Pattern.compile("C C(\\d+) H:(\\d+) E:(\\d+) P:(\\d+)");
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
	
	public void addJuggler(Juggler j) {
		this.jugglers.add(j);
	}
	
	public int getSize() {
		return jugglers.size();
	}
	
	@Override
	public String toString() {
//		C2 J6 C2:128 C1:31 C0:188, J3 C2:120 C0:171 C1:31, J10 C0:120 C2:86 C1:21, J0 C2:83 C0:104 C1:17
		return "C" + id + " " + StringUtils.join(jugglers, ", ");
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
	
	
}
