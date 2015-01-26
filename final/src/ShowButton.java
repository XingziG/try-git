/**
 * @fileName ShowButtons.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Final Applet
 * @date Last Modified: 12/11/2014
 * @description: This java Applet containing a single button labled "Dear Professor". When click on this button, a message dialog box opens,
 * displaying "Happy Holidays"!
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class ShowButton extends JApplet {

	JButton b1 = new JButton("Dear Professor"); //This is the button labled "Dear Professor".
	BL bListener = new BL(); //The button listener will listen the event happens on the button.
	JLabel message;  
	
	private class BL implements ActionListener {
		public void actionPerformed(ActionEvent e) { // when click action performed
			JOptionPane.showMessageDialog(null, "Happy Holidays!"); // we show a new dialog box and display "Happy Holidays!"
		}
	}

	public void init() { // to init the Applet
		b1.addActionListener(bListener); 
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		message = new JLabel("Click the button to open", JLabel.CENTER);
		cp.add(message);
		cp.add(b1);
	}
}
