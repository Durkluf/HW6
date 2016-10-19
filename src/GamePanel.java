/**
 * 
 */


import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * @author tuman_000
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	GPanel[] gPanels;
	public GamePanel() {
	}

	public void addImagesEquations(BufferedImage[] imgs, String operand, int i) {
		for(Image img : imgs){
			add(new GPanel(img, operand, i));
		}
	}
	
	
	
}
