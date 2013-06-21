package yodle.juggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;



public class Assigner {

	private static final String s = "C C0 H:7 E:7 P:10 \n" +
			"C C1 H:2 E:1 P:1 \n" +
			"C C2 H:7 E:6 P:4 \n" +
			" \n" +
			"J J0 H:3 E:9 P:2 C2,C0,C1 \n" +
			"J J1 H:4 E:3 P:7 C0,C2,C1 \n" +
			"J J2 H:4 E:0 P:10 C0,C2,C1 \n" +
			"J J3 H:10 E:3 P:8 C2,C0,C1 \n" +
			"J J4 H:6 E:10 P:1 C0,C2,C1 \n" +
			"J J5 H:6 E:7 P:7 C0,C2,C1 \n" +
			"J J6 H:8 E:6 P:9 C2,C1,C0 \n" +
			"J J7 H:7 E:1 P:5 C2,C1,C0 \n" +
			"J J8 H:8 E:2 P:3 C1,C0,C2 \n" +
			"J J9 H:10 E:2 P:1 C1,C2,C0 \n" +
			"J J10 H:6 E:4 P:5 C0,C2,C1 \n" +
			"J J11 H:8 E:4 P:7 C0,C1,C2";
	
	List<Juggler> jugglers = new ArrayList<Juggler>();
	List<Course> courses = new ArrayList<Course>();
	
	public Assigner(BufferedReader in) throws IOException {
		String line = in.readLine();
		
		while (line != null) {
			if (line.startsWith("C")) {
				courses.add(new Course(line));
			} else if (line.startsWith("J")) {
				jugglers.add(new Juggler(line, courses));
			}
			line = in.readLine();
		}	
	}
	
	public void assign(PrintStream out) {
		Collections.sort(jugglers);
		for (Juggler j : jugglers) {
			for (CoursePreference cp : j.getPrefs()) {
				if (cp.getC().getSize() < (jugglers.size() / courses.size())) {
					cp.getC().addJuggler(j);
					break;
				}
			}
			
		}
		
		for (Course c : courses) {
			out.println(c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new StringReader(s));
			Assigner assigner = new Assigner(in);
			assigner.assign(System.out);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
}
