/**
 * 
 */


import java.awt.Image;
import javax.swing.JPanel;

/**
 * @author tuman_000
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	GPanel[] gPanels;
	String operand;
	int i;
	public GamePanel() {
	}

	public void addImagesEquations(Image[] imgs) {
		for(Image img : imgs){
			add(new GPanel(img, operand, i));
		}
	}
	
	public void setOperand(String o){
		this.operand = o;
	}
	
	public void setInteger(int i){
		this.i = i;
	}
	
}
