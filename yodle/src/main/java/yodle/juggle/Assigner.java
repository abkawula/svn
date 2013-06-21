package yodle.juggle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;



public class Assigner {
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
		
		Course.setMaxSize(jugglers.size() / courses.size());
	}
	
	public void assign(PrintStream out) {
		for (Juggler j : jugglers) {
			j.chooseCourse(null);
		}
		
		Collections.reverse(courses);
		for (Course c : courses) {
			out.println(c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			printUsage();
		} else {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(args[0]));
				Assigner assigner = new Assigner(in);
				assigner.assign(new PrintStream(args[1]));
			} finally {
				IOUtils.closeQuietly(in);
			}
		}
	}
	
	private static void printUsage() {
		System.out.println("Usage: java -cp target/yodle-1.0-SNAPSHOT.jar [input File] [output File]");
	}
	
}
