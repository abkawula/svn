package mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HopFormatter {

	private static Map<String, Hop> hops = new LinkedHashMap<String, Hop>();
	
	public void loadHopsFromFile() {
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader (new File("Hops.txt")));
			
			String line = null;
			int id = 1;
			
			
			while ((line = in.readLine()) != null) {
				String[] fields = line.split("\\t");
				if (fields.length > 1) {
					if (fields.length != 4) {
						System.out.println(line + " is a problem");
					}
					String name = fields[0].trim();
					double alpha = getAlpha(fields[1].trim());
					String subs = fields[2].trim();
					String description = fields[3].trim();
					
					if (hops.get(name) == null) {
						hops.put(name, new Hop(id, name, alpha, description, subs));
						id++;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in !=null) {
				try { in.close(); } catch (Exception e) {}
			}
		}	
	}
	
	private void createInsertfile() {
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(new File("dbFile.txt"));
			
			for (Hop h : hops.values()) {
				out.println("insert into Hop(id, name, alpha, description) values (" + h.getId() + ", '" + h.getName().replaceAll("'", "''") + "', " + h.getAlpha() + ", '" + h.getDescription().replaceAll("'", "''") + "');");
			}
			
			out.println();
			
			for (Hop h : hops.values()) {
				for(String sub : h.getSubs().split(", ")) {
					List<Integer> subIds = getSubIds(sub.trim());
					for (int subId : subIds) {
						out.println("insert into Hop_Hop(Hop_id, substitutions_id) values (" + h.getId() + ", " + subId + ");");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out !=null) {
				try { out.close(); } catch (Exception e) {}
			}
		}	
	}
	
	private static Set<String> ignore = new HashSet<String>();
	static {
		ignore.add("German Spalt Select");
		ignore.add("German Spalt");
		ignore.add("possible American \"C\" hops");
	}
	private List<Integer> getSubIds(String name) {
		if (ignore.contains(name)) {
			return new LinkedList<Integer>();
		}
		
		List<Integer> ids = new LinkedList<Integer>();
		for (Hop h : hops.values()) {
			if (h.getName().indexOf(name) > -1) {
				ids.add(h.getId());
			}
		}
		
		if (ids.size() > 0) {
			return ids;
		} else {
			throw new RuntimeException("Could not find hop that matched " + name);
		}
	}
	
	public static void main(String[] args) {
		HopFormatter h = new HopFormatter();
		h.loadHopsFromFile();
		h.createInsertfile();
	}

	private static final Pattern alphaPattern1 = Pattern.compile("([0-9\\.]+)-([0-9\\.]+)%");
	private static final Pattern alphaPattern2 = Pattern.compile("([0-9\\.]+)%");
	private double getAlpha(String raw) {
		Matcher m = alphaPattern1.matcher(raw);
		if (m.matches()) {
			double d1 = Double.parseDouble(m.group(1));
			double d2 = Double.parseDouble(m.group(2));
			return (d1 + d2) / 2;
		}
		
		m = alphaPattern2.matcher(raw);
		if (m.matches()) {
			return Double.parseDouble(m.group(1));
		}
		
		throw new RuntimeException(raw + " doesn't match any alpha pattern");
	}
	
	private class Hop {
		int id;
		String name;
		double alpha;
		String description;
		String subs;
		
		public Hop(int id, String name, double alpha, String description, String subs) {
			this.id = id;
			this.name = name;
			this.alpha = alpha;
			this.description = description;
			this.subs = subs;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public double getAlpha() {
			return alpha;
		}

		public String getDescription() {
			return description;
		}
		
		public String getSubs() {
			return subs;
		}
		
		
	}
}
