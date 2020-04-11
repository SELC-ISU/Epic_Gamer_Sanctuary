package home;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import connectfour.ConnectFour_GUI;
import tictactoe.TicTacToe_GUI;
import yahtzee.Yahtzee_GUI;

public class HomeScreen  {
	
	public static void main(String[] args) {
		HomeScreen test = new HomeScreen();
	}
	
	public static CardLayout mainScreen = new CardLayout(40,30);
	public static Container c;
	JFrame frame;
	JButton b1, b2, b3;
	JPanel panel;
	
	public HomeScreen() {
		//c = getContentPane();
		
		frame = new JFrame("Game Center");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		
		b1 = new JButton("Tic Tac Toe");
		b2 = new JButton("Connect Four");
		b3 = new JButton("Yahtzee");
		
		b1.setName("TTT");
		b2.setName("CF");
		b3.setName("Y");
		
		b1.addActionListener(new ButtonActionListener());
		b2.addActionListener(new ButtonActionListener());
		b3.addActionListener(new ButtonActionListener());
		
		panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
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
			else if(((AbstractButton) e.getSource()).getName().compareTo("Y") == 0) {
				Yahtzee_GUI game = new Yahtzee_GUI();
			}
		}
	}
}
