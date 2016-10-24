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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
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
	private boolean othersWorking;
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
	
	long startTime;
	long endTime;
	ArrayList<Long> times = new ArrayList<Long>();
	
	boolean done;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPanel(Image img, String operand, int i) {
		Random r = new Random();
		this.rand = r.nextInt(12);
		this.operand = operand;
		this.i = i;
		done = false;
		othersWorking = false;
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
	public long getTime(){
		long sum = 0;
		for (long x : times)
			sum += x;
		return sum;
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
	public Boolean isWorking(){
		return working;
	}
	public Boolean isDone(){
		return done;
	}
	public void setOthersWorking(){
		othersWorking = true;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!answered) {
			if (working){
				CustomActionListener cAL = new CustomActionListener();
				ansField.addActionListener(cAL);
				g2.setColor(Color.lightGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.yellow);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString(eqnString, w/3, h/2);
				repaint();
				startTime = System.nanoTime();
			}
			else if (!working){
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, w, h);
				repaint();
			}
		} else {
			g2.drawImage(img, 0, 0, this);
			done = true;
			repaint();
		} 
	}


	class CustomMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			if (!othersWorking){
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
	
	class CustomActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			System.out.print("beginning");
			JTextField textField = (JTextField) e.getSource();
			userAns = Integer.parseInt(textField.getText());
			if (userAns == answer){
				endTime = System.nanoTime();
				times.add(startTime - endTime);
				setAnswered(true);
			}else{
				if (count == 2){
					endTime = System.nanoTime();
					ansField.setText(Integer.toString(answer));
				}else{
					count++;
				}
			}
		}
	}
}




