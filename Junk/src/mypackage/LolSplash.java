package mypackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;

public class LolSplash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String url;
			String splashPath;
			String cssSelector;
			
			if (args.length != 3) {
				printUsage();
				return;
			} else {
				url = args[0];
				splashPath = args[1];
				cssSelector = args[2];
			}
			
			String imageUrl = getImageUrl(url, cssSelector);
			URL u = new URL(imageUrl);
			File image = getImageFile(imageUrl);
			writeSplashBMP(image, splashPath);
			image.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void printUsage() {
		System.out.println("Usage: java [url] [splashFile] [cssSelector]");
		System.out.println("where:");
		System.out.println("\turl: the url that holds the image you want");
		System.out.println("\tsplashFile: the absolute filename of the splash screen image");
		System.out.println("\tcssSelector: A selector that will return an image tag in the url you specified");
	}
	
	private static String getImageUrl(String url, String selector) throws Exception {
		Parser parser = new Parser(url);
		
		NodeFilter filter = new CssSelectorNodeFilter(selector);
		
		NodeList nodeList = parser.parse(filter);
		
		for (Node node : nodeList.toNodeArray()) {
			try {
				ImageTag image = (ImageTag) node;
				return image.getImageURL();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new Exception("No Image found at " + url);
	}
	
	private static File getImageFile(String imageUrl) throws Exception {
		InputStream in = null;
		FileOutputStream out = null;
		File file;
		try {
			URL url = new URL(imageUrl);
			String filename = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
			file = new File(filename);
			in = url.openConnection().getInputStream();
			out = new FileOutputStream(file);
			IOUtils.copy(in, out);
			
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return file;
	}
	
	private static void writeSplashBMP(File image, String splashPath) throws Exception {
		BufferedImage bimage = ImageIO.read(image);
		
		//Create a file for the output  
		File output = new File(splashPath);  
		//Write the image to the destination as a BMP  
		ImageIO.write(bimage, "bmp", output);  
	}

}
