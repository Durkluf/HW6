/**
 * 
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	public JTextField ansField;
	
	String eqnString;
	String operand = "+";
	int i = 1;
	int rand;
	int answer;
	int userAns;
	int count;
	boolean canContinue = true;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPanel(Image img, String operand, int i) {
		Random r = new Random();
		this.rand = r.nextInt(12);
		this.operand = operand;
		this.i = i;
		eqnString = i + operand + rand + "= ?";
		this.answer = solveAnswer();
		ansField = new JTextField(5);
		this.img = img;
		count = 0;
		w = img.getWidth(this);
		h = img.getHeight(this);
		setPreferredSize(new Dimension(w, h));
		addMouseListener(new CustomMouseListener());
		add(ansField);
		answered = false;
		working = false;
	}
	
	private int solveAnswer(){
		int answer = 0;
		if(operand == "/")
			answer = i / rand;
		if (operand == "*")
			answer = i * rand;
		if (operand == "+")
			answer = i + rand;
		if (operand == "-")
			answer = i - rand;
		return answer;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public String getEqnString(){
		return eqnString;
	}

	public void setAnswered(Boolean b) {
		answered = b;
	}

	public boolean getAnswered() {
		return answered;
	}
	
	public void setWorking(Boolean b){
		working = b;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!answered) {
			if (working && canContinue){
				this.canContinue = false;
				ansField.addActionListener(new AbstractAction() {
					public void actionPerformed(ActionEvent e){
						JTextField textField = (JTextField) e.getSource();
						userAns = Integer.parseInt(textField.getText());
						if (userAns == answer){
							setAnswered(true);
						}else{
							if (count == 2){
								ansField.setText(Integer.toString(answer));
								canContinue = true;
							}else{
								count++;
							}
						}
					}
				});
				g2.setColor(Color.lightGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.yellow);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString(eqnString, w/3, h/2);
				repaint();
			}
			else{
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, w, h);
				repaint();
			}
		} else {
			g2.drawImage(img, 0, 0, this);
			((JFrame)SwingUtilities.getRoot(this)).setTitle("Testing GPanel");
			repaint();
		} 
	}


	class CustomMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			Object source = event.getSource();
			if (source instanceof JPanel){
				JPanel panelPressed = (JPanel) source;
				setWorking(true);
			} else {
				setWorking(false);
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}




