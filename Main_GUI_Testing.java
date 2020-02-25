import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main_GUI_Testing extends JFrame implements ActionListener {
	
	public static CardLayout mainScreen = new CardLayout(40,30);
	public static Container c;
	JButton b1, b2, b3;
	
	public Main_GUI_Testing() {
		//c = getContentPane();
		
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		b3 = new JButton("Button 3");
		
		b1.addActionListener(this);
	}
}
