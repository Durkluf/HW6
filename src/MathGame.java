import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

/**
 * @author tuman_000
 *
 */
public class MathGame extends JFrame {
	public GamePanel gamePanel;
	public String fileName = "doggo.jpg";
	public int rows = 2;
	public int cols = 2;
	public int i = 0;
	public String operand = "+";
	
	private static final long serialVersionUID = 1L;
	
	public MathGame(BufferedImage[] imgs){
		setTitle("Math Games");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TopMenu topMenu = new TopMenu();
		setJMenuBar(topMenu.menu(this));
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(2, 2, 1, 1));
		gamePanel.addImagesEquations(imgs, operand, i);
		
		add(gamePanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static BufferedImage[] splitImage(String fileName, int rows, int cols, boolean saveToFile) {
		BufferedImage[] imgs = new BufferedImage[rows * cols]; // Image array to
																// hold image
																// pieces
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
				for (int i = 0; i < imgs.length; i++) {
					ImageIO.write(imgs[i], "jpg", new File(fileName + i + ".jpg"));
				}
				System.out.println("Mini images created");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return imgs;
	}
	
	/**
	 * sets or resets image for game
	 * @param fileName
	 */
	public void setImages(String fileName) {
		this.fileName = fileName;
		remove(gamePanel);
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(rows, cols, 1, 1));
		gamePanel.addImagesEquations(splitImage(fileName, rows, cols, false), operand, i);
		add(gamePanel, BorderLayout.CENTER);
		repaint();
	}
	
	/**
	 * sets or resets size of game (4, 9, or 12)
	 * @param rows 
	 * @param cols
	 */
	public void setSize(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		remove(gamePanel);
		
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(rows, cols, 1, 1));
		gamePanel.addImagesEquations(splitImage(fileName, rows, cols, false), operand, i);
		add(gamePanel, BorderLayout.CENTER);
		repaint();
	}
	
	public void setOperand(String o){
		this.operand = o;	
		remove(gamePanel);	
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(rows, cols, 1, 1));
		gamePanel.addImagesEquations(splitImage(fileName, rows, cols, false), operand, i);
		add(gamePanel, BorderLayout.CENTER);
		repaint();
	}
	
	public void setInteger(int i){
		this.i = i;
		remove(gamePanel);	
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(rows, cols, 1, 1));
		gamePanel.addImagesEquations(splitImage(fileName, rows, cols, false), operand, i);
		add(gamePanel, BorderLayout.CENTER);
		repaint();

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedImage[] imgs = null;
		try {
			imgs = splitImage("doggo.jpg", 2, 2, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MathGame mg = new MathGame(imgs);
		

	}
	
	

}
