import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SubmitButton implements ActionListener, KeyListener {

    JTextField answer;


    public SubmitButton(JTextField textfield){
        answer = textfield;
    }

    @Override
    public void actionPerformed(ActionEvent submitClicked) {
    	int ans = Integer.parseInt(answer.getText());
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Hello");
        }
        

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}