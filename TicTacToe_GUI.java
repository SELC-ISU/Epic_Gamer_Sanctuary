import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe_GUI {

	JFrame frame;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	JLabel label;
	JPanel panel1, panel2;
	int turn;
	TicTacToe game;
	
	public TicTacToe_GUI() {
		turn = 1;
		
		game = new TicTacToe();
		
		
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		label = new JLabel("Player " + turn + " it is your turn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		button5 = new JButton("Button 5");
		button6 = new JButton("Button 6");
		button7 = new JButton("Button 7");
		button8 = new JButton("Button 8");
		button9 = new JButton("Button 9");
		
		button1.setName("1");
		button2.setName("2");
		button3.setName("3");
		button4.setName("4");
		button5.setName("5");
		button6.setName("6");
		button7.setName("7");
		button8.setName("8");
		button9.setName("9");
		
		
		updateBoard();
		
		button1.setFont(new Font("Arial", Font.PLAIN, 70));
		button2.setFont(new Font("Arial", Font.PLAIN, 70));
		button3.setFont(new Font("Arial", Font.PLAIN, 70));
		button4.setFont(new Font("Arial", Font.PLAIN, 70));
		button5.setFont(new Font("Arial", Font.PLAIN, 70));
		button6.setFont(new Font("Arial", Font.PLAIN, 70));
		button7.setFont(new Font("Arial", Font.PLAIN, 70));
		button8.setFont(new Font("Arial", Font.PLAIN, 70));
		button9.setFont(new Font("Arial", Font.PLAIN, 70));
		
		button1.addActionListener(new ButtonActionListener());
		button2.addActionListener(new ButtonActionListener());
		button3.addActionListener(new ButtonActionListener());
		button4.addActionListener(new ButtonActionListener());
		button5.addActionListener(new ButtonActionListener());
		button6.addActionListener(new ButtonActionListener());
		button7.addActionListener(new ButtonActionListener());
		button8.addActionListener(new ButtonActionListener());
		button9.addActionListener(new ButtonActionListener());
		
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
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
		//panel1.add(panel2);
		
		//frame.add(panel1);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel2, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		
		
	}
	
	private void updateBoard() {
		button1.setText(game.getBoardSpot(0, 0));
		button2.setText(game.getBoardSpot(0, 1));
		button3.setText(game.getBoardSpot(0, 2));
		button4.setText(game.getBoardSpot(1, 0));
		button5.setText(game.getBoardSpot(1, 1));
		button6.setText(game.getBoardSpot(1, 2));
		button7.setText(game.getBoardSpot(2, 0));
		button8.setText(game.getBoardSpot(2, 1));
		button9.setText(game.getBoardSpot(2, 2));
	}
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int spot = Integer.parseInt(((AbstractButton) e.getSource()).getName());
			spot--;
			int x = spot % 3;
			int y = spot / 3;
			if(game.move(turn, x, y)) {
				updateBoard();
				
				if(turn == 1) {
					turn = 2;
				}
				else {
					turn = 1;
				}
				label.setText("Player " + turn + " it is your turn");
				
				((AbstractButton) e.getSource()).setEnabled(false);
				
				if(game.gameOver() == 1) {
					int winner = game.whoWon();
					
					label.setText("PLAYER " + winner + " HAS WON THE GAME!");
					
					disableAllButtons();
				}
				else if(game.gameOver() == 2) {
					label.setText("The game ends in a tie");
				}
			}
			
			
			
		}
	}
	
	private void disableAllButtons() {
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
	}
}