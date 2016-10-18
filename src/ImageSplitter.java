

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

/**
 * ImageSplit class contains a main method thats finds and splits a picture from
 * the directory
 */
public class ImageSplitter {

	/**
	 * Finds a designated picture file in directory and splits into a
	 * predetermined number of pieces Each split piece of the picture is later
	 * stored as a separate picture (original picture is left intact)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static Image[] splitImage(String fileName, int rows, int cols, boolean saveToFile) {
		BufferedImage[] imgs = new BufferedImage[rows * cols]; // Image array to hold images
		Image[] images = new Image[rows*cols];								
															
		try {
			File file = new File(fileName); // takes picture from
														// directory
			FileInputStream fis = new FileInputStream(file);
			BufferedImage image = ImageIO.read(fis); // reading the image file

			int pieceWidth = image.getWidth() / cols; // determines the width
			int pieceHeight = image.getHeight() / rows; // and height of each piece

			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					// Initialize the image array with image pieces
					imgs[x * rows + y] = new BufferedImage(pieceWidth, pieceHeight, image.getType());
					// draws the image piece
					Graphics2D gr = imgs[x * rows + y].createGraphics();
					gr.drawImage(image, 0, 0, pieceWidth, pieceHeight, pieceWidth * y, pieceHeight * x,
							pieceWidth * y + pieceWidth, pieceHeight * x + pieceHeight, null);
					gr.dispose();
				}
			}
			System.out.println("Splitting done");
			if (saveToFile) {
				// writing mini images into image files
				String name = fileName.split(".")[0];
				for (int i = 0; i < imgs.length; i++) {
					ImageIO.write(imgs[i], "jpg", new File(name + i + ".jpg"));
				}
				System.out.println("Mini images created");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		for(int i = 0; i < rows*cols; i++)
			images[i] = (Image) imgs[i];
			
		return images;

	}

	public static void main(String[] args) throws Exception {
		String fileName = "bear.jpg";
		Image[] imgs = ImageSplitter.splitImage(fileName, 2, 2, false);
	}

}
