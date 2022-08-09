import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	//create static function with name of the file as parameter
	public static void readImage(String fileName) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {

		readImage("Lena.png");

	}
}
