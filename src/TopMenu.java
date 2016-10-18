/**
 * 
 */
package mathGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * @author Maxwell
 *
 */
public class TopMenu {
	JTextArea output;
	JScrollPane scrollPane;
	String fileName;
	/**
	 * Creates 2 top menu options with radio options and checkbox items and
	 * submenu.
	 * 
	 * @return
	 */

	public JMenuBar menu(MathViewer viewer) {
		JMenuBar menuBar;
		JMenu menu;
		JMenu submenu;
		JMenu submenu1;
		fileName = "bear.jpg";
		// Creates the first menu
		menuBar = new JMenuBar();

		// Outside the first menu- Name on top
		menu = new JMenu("Settings");
		menuBar.add(menu);

		// Separator & new button group
		//menu.addSeparator();
		ButtonGroup radiogroup = new ButtonGroup();
		// Creates either/or options
		JRadioButtonMenuItem radioItemA = new JRadioButtonMenuItem("Image 1");
		radioItemA.setSelected(true);
		// Assigns shortcut
		radiogroup.add(radioItemA);
		menu.add(radioItemA);

		JRadioButtonMenuItem radioItemB = new JRadioButtonMenuItem("Image 2");
		radiogroup.add(radioItemB);
		menu.add(radioItemB);
		
		JRadioButtonMenuItem radioItemC = new JRadioButtonMenuItem("Image 3");
		radiogroup.add(radioItemC);
		menu.add(radioItemC);
		
		//Add Separator
		
		menu.addSeparator();
		
		//Creates either/or options
		ButtonGroup radiogroup2 = new ButtonGroup();
		
		JRadioButtonMenuItem radioItemA1 = new JRadioButtonMenuItem("4 Problems");
		radioItemA1.setSelected(true);
		radiogroup2.add(radioItemA1);
		menu.add(radioItemA1);

		JRadioButtonMenuItem radioItemB1 = new JRadioButtonMenuItem("9 Problems");
		radiogroup2.add(radioItemB1);
		menu.add(radioItemB1);
		
		JRadioButtonMenuItem radioItemC1 = new JRadioButtonMenuItem("12 Promlems");
		radiogroup2.add(radioItemC1);
		menu.add(radioItemC1);

		// Add a submenu
		menu.addSeparator();
		submenu = new JMenu("Numbers");
		
		ButtonGroup radiogroup3 = new ButtonGroup();

		JRadioButtonMenuItem menuItemA = new JRadioButtonMenuItem("0");
		menuItemA.setSelected(true);
		radiogroup3.add(menuItemA);
		submenu.add(menuItemA);
		
		JRadioButtonMenuItem menuItemB = new JRadioButtonMenuItem("1");
		radiogroup3.add(menuItemB);
		submenu.add(menuItemB);
		
		JRadioButtonMenuItem menuItemC = new JRadioButtonMenuItem("2");
		radiogroup3.add(menuItemC);
		submenu.add(menuItemC);
		
		JRadioButtonMenuItem menuItemD = new JRadioButtonMenuItem("3");
		radiogroup3.add(menuItemD);
		submenu.add(menuItemD);
		
		JRadioButtonMenuItem menuItemE = new JRadioButtonMenuItem("4");
		radiogroup3.add(menuItemE);
		submenu.add(menuItemE);
		
		JRadioButtonMenuItem menuItemF = new JRadioButtonMenuItem("5");
		radiogroup3.add(menuItemF);
		submenu.add(menuItemF);
		
		JRadioButtonMenuItem menuItemG = new JRadioButtonMenuItem("6");
		radiogroup3.add(menuItemG);
		submenu.add(menuItemG);
		
		JRadioButtonMenuItem menuItemH = new JRadioButtonMenuItem("7");
		radiogroup3.add(menuItemH);
		submenu.add(menuItemH);
		
		JRadioButtonMenuItem menuItemI = new JRadioButtonMenuItem("8");
		radiogroup3.add(menuItemI);
		submenu.add(menuItemI);
		
		JRadioButtonMenuItem menuItemJ = new JRadioButtonMenuItem("9");
		radiogroup3.add(menuItemJ);
		submenu.add(menuItemJ);
		
		JRadioButtonMenuItem menuItemK = new JRadioButtonMenuItem("10");
		radiogroup3.add(menuItemK);
		submenu.add(menuItemK);
		
		JRadioButtonMenuItem menuItemL = new JRadioButtonMenuItem("11");
		radiogroup3.add(menuItemL);
		submenu.add(menuItemL);
		
		JRadioButtonMenuItem menuItemM = new JRadioButtonMenuItem("12");
		radiogroup3.add(menuItemM);
		submenu.add(menuItemM);
		
		menu.add(submenu);
		
		// Add a submenu
		menu.addSeparator();
		submenu1 = new JMenu("Operators");
		
		ButtonGroup radiogroup4 = new ButtonGroup();

		JRadioButtonMenuItem menuItemA1 = new JRadioButtonMenuItem("+");
		menuItemA1.setSelected(true);
		radiogroup4.add(menuItemA1);
		submenu1.add(menuItemA1);
		
		JRadioButtonMenuItem menuItemB1 = new JRadioButtonMenuItem("-");
		radiogroup4.add(menuItemB1);
		submenu1.add(menuItemB1);
		
		JRadioButtonMenuItem menuItemC1 = new JRadioButtonMenuItem("*");
		radiogroup4.add(menuItemC1);
		submenu1.add(menuItemC1);
		
		JRadioButtonMenuItem menuItemD1 = new JRadioButtonMenuItem("/");
		radiogroup4.add(menuItemD1);
		submenu1.add(menuItemD1);
		
		menu.add(submenu1);
		
		// Add Seperator
		menu.addSeparator();
		
		// Add Exit
		
		JMenuItem exit = new JMenuItem("Exit");
		menu.add(exit);

		menuItemA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(0);
			}
		});

		menuItemB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(1);
			}
		});

		menuItemC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(2);
			}
		});

		menuItemD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(3);
			}
		});

		menuItemE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(4);
			}
		});

		menuItemF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(5);
			}
		});

		menuItemG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(6);
			}
		});

		menuItemH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(7);
			}
		});
		
		menuItemI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(8);
			}
		});
		
		menuItemJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(9);
			}
		});
		
		menuItemK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(10);
			}
		});
		
		menuItemL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(11);
			}
		});
		
		menuItemM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInteger(12);
			}
		});
		
		menuItemA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOperand("+");
			}
		});

		menuItemB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOperand("-");
			}
		});

		menuItemC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOperand("*");
			}
		});

		menuItemD1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOperand("/");
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		radioItemA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setImages("doggo.jpg");
			}
		});

		radioItemB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setImages("duck.jpg");
			}
		});
		
		radioItemC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setImages("sapce.jpg");	
			}
		});
		
		radioItemA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSize(2,2);
			}
		});

		radioItemB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSize(3,3);
			}
		});
		
		radioItemC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSize(4,4);
			}
		});

		return menuBar;
	}

}

