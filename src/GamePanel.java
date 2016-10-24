/**
 * 
 */


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author tuman_000
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<GPanel> gPanels;
	private Boolean finished;
	public GamePanel() {
		gPanels = new ArrayList<GPanel>();
		finished = false;
	}

	public void addImagesEquations(BufferedImage[] imgs, String operand, int i) {
		for(Image img : imgs){
			gPanels.add(new GPanel(img, operand, i));
		}
		for(GPanel gP : gPanels){
			add(gP);
		}
	}
	
	public void checkFinished(){
		for (GPanel gp : gPanels){
			Boolean gb = gp.isDone();
			if (gb == false){
				finished = false;
				break;
			} else {
				finished = true;
			}
		}
	}

	public Boolean isFinished(){
		return finished;
	}
	
}
