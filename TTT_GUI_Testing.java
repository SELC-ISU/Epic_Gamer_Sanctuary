import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class TTT_GUI_Testing {
	JFrame frame;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	JLabel label;
	JPanel panel1, panel2;
	int turn;
	
	public TTT_GUI_Testing() {
		turn = 1;
		
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		label = new JLabel("Player " + turn + " it is your turn");
		
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		button5 = new JButton("Button 5");
		button6 = new JButton("Button 6");
		button7 = new JButton("Button 7");
		button8 = new JButton("Button 8");
		button9 = new JButton("Button 9");
		
		button1.addActionListener(null);
		button2.addActionListener();
		button3.addActionListener(this);
		button4.addActionListener(null);
		button5.addActionListener(null);
		button6.addActionListener(null);
		button7.addActionListener(null);
		button8.addActionListener(null);
		button9.addActionListener(null);
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		panel2.setLayout(new GridLayout(3, 3));
		
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(button7);
		panel2.add(button8);
		panel2.add(button9);
		
		panel1.add(label);
		panel1.add(panel2);
		
		frame.add(panel1);
		frame.setVisible(true);
	}
	
	public void actionPeformed(ActionEvent e) {
		if(turn == 1) {
			turn = 2;
		}
		else {
			turn = 1;
		}
		label.setText("Player " + turn + " it is your turn");
	}
	
	
	public static void main(String[] args) {
		TTT_GUI_Testing test = new TTT_GUI_Testing();
	}
}
