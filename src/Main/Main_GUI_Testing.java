package Main;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import TicTacToe.TicTacToe_GUI;
import ConnectFour.ConnectFour_GUI;

public class Main_GUI_Testing  {
	
	public static void main(String[] args) {
		System.out.println("Test");
		Main_GUI_Testing test = new Main_GUI_Testing();
	}
	
	public static CardLayout mainScreen = new CardLayout(40,30);
	public static Container c;
	JFrame frame;
	JButton b1, b2;
	JPanel panel;
	
	public Main_GUI_Testing() {
		//c = getContentPane();
		
		frame = new JFrame("Game Center");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		
		b1 = new JButton("Tic Tac Toe");
		b2 = new JButton("Connect Four");
		
		b1.setName("TTT");
		b2.setName("CF");
		
		b1.addActionListener(new ButtonActionListener());
		b2.addActionListener(new ButtonActionListener());
		
		panel = new JPanel();
		
		panel.add(b1);
		panel.add(b2);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(((AbstractButton) e.getSource()).getName().compareTo("TTT") == 0) {
				TicTacToe_GUI game = new TicTacToe_GUI();
			}
			else if(((AbstractButton) e.getSource()).getName().compareTo("CF") == 0) {
				ConnectFour_GUI game = new ConnectFour_GUI();
			}
		}
	}
}
