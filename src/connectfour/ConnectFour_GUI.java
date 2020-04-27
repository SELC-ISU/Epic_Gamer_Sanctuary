package connectfour;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class ConnectFour_GUI {
	
	JFrame frame;
	JButton[] gameButtons;
	JLabel label;
	JLabel[][] gameLabels;
	JPanel panel1, panel2, panel3;
	int turn;
	ConnectFour game;
	JButton replay;
	
	public ConnectFour_GUI() {
		turn = 1;
		
		game = new ConnectFour();
		
		frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 600);
		
		label = new JLabel("Player " + turn + " it is your turn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		gameButtons = new JButton[7];
		
		for(int i = 0; i < gameButtons.length; i++) {
			gameButtons[i] = new JButton("Col " + (i+1));
			gameButtons[i].setName((i+1) + "");
			gameButtons[i].addActionListener(new ButtonActionListener());
		}
		
		int font = 70;
		
		gameLabels = new JLabel[6][7];
		
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				gameLabels[i][j] = new JLabel("*");
				gameLabels[i][j].setFont(new Font("Arial", Font.PLAIN, font));
			}
		}
	
		updateBoard();
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		panel2.setLayout(new GridLayout(6,7));
		
		panel1.add(label);
		
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				panel2.add(gameLabels[i][j]);
			}
		}

		for(int i = 0; i < gameButtons.length; i++) {
			panel3.add(gameButtons[i]);
		}

		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.PAGE_END);
		
		frame.setVisible(true);
	}
	
	private void updateBoard() {
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				gameLabels[i][j].setText(game.getBoardSpot(i, j));
			}
		}
	}
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int col = Integer.parseInt(((AbstractButton) e.getSource()).getName());
			
			if(col == 60) {
				frame.remove(replay);
				frame.add(panel3, BorderLayout.PAGE_END);
				
				enableButtons();
				
				clearBorders();
				
				game = new ConnectFour();
				
				updateBoard();
				
				turn = 1;
				label.setText("Player " + turn + " it is your turn");
				
				return;
			}
			
			col--;
			
			if(game.move(turn, col)) {
				updateBoard();
				
				if(turn == 1) {
					turn = 2;
				}
				else {
					turn = 1;
				}
				label.setText("Player " + turn + " it is your turn");
				
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
	
	private void clearBorders() {
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				gameLabels[i][j].setBorder(border);
			}
		}
	}
	
	private void enableButtons() {
		for(int i = 0; i < gameButtons.length; i++) {
			gameButtons[i].setEnabled(true);
		}
	}
	
	private void playAgain() {
		replay = new JButton("Click to play again");
		replay.setName("60");
		replay.addActionListener(new ButtonActionListener());
		
		frame.remove(panel3);
		frame.add(replay, BorderLayout.PAGE_END);
	}
	
	private void setWinHighlight() {
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				if(game.getHighlight(i, j)) {
					gameLabels[i][j].setBorder(border);
				}
			}
		}		
	}
	
	private void disableAllButtons() {
		for(int i = 0; i < gameButtons.length; i++) {
			gameButtons[i].setEnabled(false);
		}
	}
}
