/**
 * 
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author tuman_000
 *
 */
public class GPanel extends JPanel {
	private Image img;
	private boolean answered;
	private boolean working;
	private int w;
	private int h;
	
	String eqnString;
	String operand = "+";
	int i = 1;
	int r;
	int answer;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPanel(Image img, String operand, int i) {
		int r = 1 + (int)Math.random() * ((12-1) + 1);
		this.r = r;
		this.operand = operand;
		this.i = i;
		eqnString = i + operand + r + "= ?";
		this.answer = solveAnswer();
		
		this.img = img;
		w = img.getWidth(this);
		h = img.getHeight(this);
		setPreferredSize(new Dimension(w, h));
		answered = false;
		working = false;
	}
	
	private int solveAnswer(){
		int answer = 0;
		if(operand == "/")
			answer = i / r;
		if (operand == "*")
			answer = i * r;
		if (operand == "+")
			answer = i + r;
		if (operand == "-")
			answer = i - r;
		return answer;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public String getEqnString(){
		return eqnString;
	}

	public void setAnswered() {
		answered = true;
	}

	public boolean getAnswered() {
		return answered;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!answered) {
			if (working){
				g2.setColor(Color.lightGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.yellow);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString(eqnString, w/3, h/2);
				((JFrame)SwingUtilities.getRoot(this)).setTitle("Testing, one, two, three.");
			}
			else{
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, w, h);
			}
		} else {
			g2.drawImage(img, 0, 0, this);
			((JFrame)SwingUtilities.getRoot(this)).setTitle("Testing GPanel");
		} 
	}


	class CustomActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}


