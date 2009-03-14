package mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarleyFormatter {

	
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			
			in = new BufferedReader(new FileReader (new File("Grains.txt")));
			out = new PrintWriter(new File("dbFile.txt"));
			
			String line = null;
			String country = null;
			int id = 1;
			
			while ((line = in.readLine()) != null) {
				String[] fields = line.split("\\t");
				if (fields.length == 1) {
					country = "'" + fields[0] + "'";
					
					if (fields[0].equals("other")) {
						country = "null";
					}
				} else if (fields.length > 1) {
					String name = "'" + fields[0].trim().replaceAll("'", "\\'") + "'";
					double color = getColor(fields[1].trim());
					double gravity = getGravity(fields[2].trim());
					String comment = "''";
						if (fields.length == 4) {
							comment = "'" + fields[3].trim().replaceAll("'", "\\'") + "'";
						}
					out.println("insert into Barley(id, variety, country, gravity, color, comment) " +
							"values (" + id + ", " + name + ", " + country + ", " + gravity + ", " + color + ", " + comment +");");
					id++;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in !=null) {
				try { in.close(); } catch (Exception e) {}
			}
			if (out !=null) {
				try { out.close(); } catch (Exception e) {}
			}
		}
	}
	
	private static Pattern colorPattern1 = Pattern.compile("([0-9\\.]+).");
	private static Pattern colorPattern2 = Pattern.compile("([0-9\\.]+).-([0-9\\.]+).");
	private static double getColor(String raw) {
		if (raw.equals("NA") || raw.equals("Varies")) {
			return 0.0;
		} else {
			Matcher m = colorPattern1.matcher(raw);
			if (m.matches()) {
				return Double.parseDouble(m.group(1));
			}
			
			m = colorPattern2.matcher(raw);
			if (m.matches()) {
				return ((Double.parseDouble(m.group(1)) + Double.parseDouble(m.group(1))) / 2);
			}
			
			throw new RuntimeException(raw + " doesn't match any known color pattern");
		}
	}
	
	private static Pattern gravityPattern1 = Pattern.compile("([0-9\\.]+)");
	private static Pattern gravityPattern2 = Pattern.compile("([0-9\\.]+)-([0-9\\.]+)");
	private static double getGravity(String raw) {
		if (raw.equals("NA")) {
			return 0.0;
		} else {
			Matcher m = gravityPattern1.matcher(raw);
			if (m.matches()) {
				return Double.parseDouble(m.group(1));
			}
			
			m = gravityPattern2.matcher(raw);
			if (m.matches()) {
				return ((Double.parseDouble(m.group(1)) + Double.parseDouble(m.group(1))) / 2);
			}
			
			throw new RuntimeException(raw + " doesn't match any known gravity pattern");
		}
	}
}
