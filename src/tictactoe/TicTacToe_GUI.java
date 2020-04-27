package tictactoe;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe_GUI {

	JFrame frame;
	JButton[][] gameButtons;
	JLabel label;
	JPanel panel1, panel2;
	int turn;
	TicTacToe game;
	JButton replay;
	
	public TicTacToe_GUI() {
		turn = 1;
		
		game = new TicTacToe();
		
		
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300,300);
		
		label = new JLabel("Player " + turn + " it is your turn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		gameButtons = new JButton[3][3];
		
		int spot = 1;
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				gameButtons[i][j] = new JButton("");
				gameButtons[i][j].setName(spot + "");
				spot++;
				gameButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 70));
				gameButtons[i][j].addActionListener(new ButtonActionListener());
			}
		}
		
		updateBoard();

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				panel2.add(gameButtons[i][j]);
			}
		}
		
		panel1.add(label);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel2, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		
		
	}
	
	private void updateBoard() {
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				gameButtons[i][j].setText(game.getBoardSpot(i, j));
			}
		}
	}
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int spot = Integer.parseInt(((AbstractButton) e.getSource()).getName());
			
			if(spot == 20) {
				frame.remove(replay);
				
				game = new TicTacToe();
				
				clearBorders();
				
				updateBoard();
				
				enableButtons();
				
				turn = 1;
				
				label.setText("Player " + turn + " it is your turn");
				
				return;
			}
			
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
					
					setWinHighlight();
					
					disableAllButtons();
					
					playAgain();
				}
				else if(game.gameOver() == 2) {
					label.setText("The game ends in a tie");
					
					playAgain();
				}
			}
			
			
			
		}
	}
	
	private void enableButtons() {
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				gameButtons[i][j].setEnabled(true);;
			}
		}
	}
	
	private void clearBorders() {
		Border border = BorderFactory.createLineBorder(Color.black, 1);

		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				gameButtons[i][j].setBorder(border);
			}
		}
	}
	
	private void playAgain() {
		replay = new JButton("Click to play again");
		replay.setName("20");
		replay.addActionListener(new ButtonActionListener());
		
		frame.add(replay, BorderLayout.PAGE_END);
	}
	
	private void setWinHighlight() {
		Border border = BorderFactory.createLineBorder(Color.blue, 5);
		
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				if(game.getHighlight(i, j)) {
					gameButtons[i][j].setBorder(border);
				}
			}
		}
	}
	
	private void disableAllButtons() {
		for(int i = 0; i < gameButtons.length; i++) {
			for(int j = 0; j < gameButtons[0].length; j++) {
				gameButtons[i][j].setEnabled(false);
			}
		}
	}
}