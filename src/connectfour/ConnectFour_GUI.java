package connectfour;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class ConnectFour_GUI {
	
	JFrame frame;
	JButton button1, button2, button3, button4, button5, button6, button7;
	JButton[] gameButtons;
	JLabel label;
	JLabel spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8, spot9, spot10, spot11, spot12, spot13, spot14;
	JLabel spot15, spot16, spot17, spot18, spot19, spot20, spot21, spot22, spot23, spot24, spot25, spot26, spot27, spot28;
	JLabel spot29, spot30, spot31, spot32, spot33, spot34, spot35, spot36, spot37, spot38, spot39, spot40, spot41, spot42;
	JLabel[][] gameLabels;
	JPanel panel1, panel2, panel3;
	int turn;
	ConnectFour game;
	
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
		
//		button1 = new JButton("Col 1");
//		button2 = new JButton("Col 2");
//		button3 = new JButton("Col 3");
//		button4 = new JButton("Col 4");
//		button5 = new JButton("Col 5");
//		button6 = new JButton("Col 6");
//		button7 = new JButton("Col 7");
//		
//		button1.setName("1");
//		button2.setName("2");
//		button3.setName("3");
//		button4.setName("4");
//		button5.setName("5");
//		button6.setName("6");
//		button7.setName("7");
//		
//		button1.addActionListener(new ButtonActionListener());
//		button2.addActionListener(new ButtonActionListener());
//		button3.addActionListener(new ButtonActionListener());
//		button4.addActionListener(new ButtonActionListener());
//		button5.addActionListener(new ButtonActionListener());
//		button6.addActionListener(new ButtonActionListener());
//		button7.addActionListener(new ButtonActionListener());
		
		int font = 70;
		
		gameLabels = new JLabel[6][7];
		
		for(int i = 0; i < gameLabels.length; i++) {
			for(int j = 0; j < gameLabels[0].length; j++) {
				gameLabels[i][j] = new JLabel("*");
				gameLabels[i][j].setFont(new Font("Arial", Font.PLAIN, font));
			}
		}
		
//		spot1 = new JLabel("*");
//		spot2 = new JLabel("*");
//		spot3 = new JLabel("*");
//		spot4 = new JLabel("*");
//		spot5 = new JLabel("*");
//		spot6 = new JLabel("*");
//		spot7 = new JLabel("*");
//		spot8 = new JLabel("*");
//		spot9 = new JLabel("*");
//		spot10 = new JLabel("*");
//		spot11 = new JLabel("*");
//		spot12 = new JLabel("*");
//		spot13 = new JLabel("*");
//		spot14 = new JLabel("*");
//		spot15 = new JLabel("*");
//		spot16 = new JLabel("*");
//		spot17 = new JLabel("*");
//		spot18 = new JLabel("*");
//		spot19 = new JLabel("*");
//		spot20 = new JLabel("*");
//		spot21 = new JLabel("*");
//		spot22 = new JLabel("*");
//		spot23 = new JLabel("*");
//		spot24 = new JLabel("*");
//		spot25 = new JLabel("*");
//		spot26 = new JLabel("*");
//		spot27 = new JLabel("*");
//		spot28 = new JLabel("*");
//		spot29 = new JLabel("*");
//		spot30 = new JLabel("*");
//		spot31 = new JLabel("*");
//		spot32 = new JLabel("*");
//		spot33 = new JLabel("*");
//		spot34 = new JLabel("*");
//		spot35 = new JLabel("*");
//		spot36 = new JLabel("*");
//		spot37 = new JLabel("*");
//		spot38 = new JLabel("*");
//		spot39 = new JLabel("*");
//		spot40 = new JLabel("*");
//		spot41 = new JLabel("*");
//		spot42 = new JLabel("*");
		
		updateBoard();
		
		
//		spot1.setFont(new Font("Arial", Font.PLAIN, font));
//		spot2.setFont(new Font("Arial", Font.PLAIN, font));
//		spot3.setFont(new Font("Arial", Font.PLAIN, font));
//		spot4.setFont(new Font("Arial", Font.PLAIN, font));
//		spot5.setFont(new Font("Arial", Font.PLAIN, font));
//		spot6.setFont(new Font("Arial", Font.PLAIN, font));
//		spot7.setFont(new Font("Arial", Font.PLAIN, font));
//		spot8.setFont(new Font("Arial", Font.PLAIN, font));
//		spot9.setFont(new Font("Arial", Font.PLAIN, font));
//		spot10.setFont(new Font("Arial", Font.PLAIN, font));
//		spot11.setFont(new Font("Arial", Font.PLAIN, font));
//		spot12.setFont(new Font("Arial", Font.PLAIN, font));
//		spot13.setFont(new Font("Arial", Font.PLAIN, font));
//		spot14.setFont(new Font("Arial", Font.PLAIN, font));
//		spot15.setFont(new Font("Arial", Font.PLAIN, font));
//		spot16.setFont(new Font("Arial", Font.PLAIN, font));
//		spot17.setFont(new Font("Arial", Font.PLAIN, font));
//		spot18.setFont(new Font("Arial", Font.PLAIN, font));
//		spot19.setFont(new Font("Arial", Font.PLAIN, font));
//		spot20.setFont(new Font("Arial", Font.PLAIN, font));
//		spot21.setFont(new Font("Arial", Font.PLAIN, font));
//		spot22.setFont(new Font("Arial", Font.PLAIN, font));
//		spot23.setFont(new Font("Arial", Font.PLAIN, font));
//		spot24.setFont(new Font("Arial", Font.PLAIN, font));
//		spot25.setFont(new Font("Arial", Font.PLAIN, font));
//		spot26.setFont(new Font("Arial", Font.PLAIN, font));
//		spot27.setFont(new Font("Arial", Font.PLAIN, font));
//		spot28.setFont(new Font("Arial", Font.PLAIN, font));
//		spot29.setFont(new Font("Arial", Font.PLAIN, font));
//		spot30.setFont(new Font("Arial", Font.PLAIN, font));
//		spot31.setFont(new Font("Arial", Font.PLAIN, font));
//		spot32.setFont(new Font("Arial", Font.PLAIN, font));
//		spot33.setFont(new Font("Arial", Font.PLAIN, font));
//		spot34.setFont(new Font("Arial", Font.PLAIN, font));
//		spot35.setFont(new Font("Arial", Font.PLAIN, font));
//		spot36.setFont(new Font("Arial", Font.PLAIN, font));
//		spot37.setFont(new Font("Arial", Font.PLAIN, font));
//		spot38.setFont(new Font("Arial", Font.PLAIN, font));
//		spot39.setFont(new Font("Arial", Font.PLAIN, font));
//		spot40.setFont(new Font("Arial", Font.PLAIN, font));
//		spot41.setFont(new Font("Arial", Font.PLAIN, font));
//		spot42.setFont(new Font("Arial", Font.PLAIN, font));
		
		
		
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
		
//		panel2.add(spot1);
//		panel2.add(spot2);
//		panel2.add(spot3);
//		panel2.add(spot4);
//		panel2.add(spot5);
//		panel2.add(spot6);
//		panel2.add(spot7);
//		panel2.add(spot8);
//		panel2.add(spot9);
//		panel2.add(spot10);
//		panel2.add(spot11);
//		panel2.add(spot12);
//		panel2.add(spot13);
//		panel2.add(spot14);
//		panel2.add(spot15);
//		panel2.add(spot16);
//		panel2.add(spot17);
//		panel2.add(spot18);
//		panel2.add(spot19);
//		panel2.add(spot20);
//		panel2.add(spot21);
//		panel2.add(spot22);
//		panel2.add(spot23);
//		panel2.add(spot24);
//		panel2.add(spot25);
//		panel2.add(spot26);
//		panel2.add(spot27);
//		panel2.add(spot28);
//		panel2.add(spot29);
//		panel2.add(spot30);
//		panel2.add(spot31);
//		panel2.add(spot32);
//		panel2.add(spot33);
//		panel2.add(spot34);
//		panel2.add(spot35);
//		panel2.add(spot36);
//		panel2.add(spot37);
//		panel2.add(spot38);
//		panel2.add(spot39);
//		panel2.add(spot40);
//		panel2.add(spot41);
//		panel2.add(spot42);
		
		for(int i = 0; i < gameButtons.length; i++) {
			panel3.add(gameButtons[i]);
		}
		
//		panel3.add(button1);
//		panel3.add(button2);
//		panel3.add(button3);
//		panel3.add(button4);
//		panel3.add(button5);
//		panel3.add(button6);
//		panel3.add(button7);
		
		
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
		
//		spot1.setText(game.getBoardSpot(0, 0));
//		spot2.setText(game.getBoardSpot(0, 1));
//		spot3.setText(game.getBoardSpot(0, 2));
//		spot4.setText(game.getBoardSpot(0, 3));
//		spot5.setText(game.getBoardSpot(0, 4));
//		spot6.setText(game.getBoardSpot(0, 5));
//		spot7.setText(game.getBoardSpot(0, 6));
//		spot8.setText(game.getBoardSpot(1, 0));
//		spot9.setText(game.getBoardSpot(1, 1));
//		spot10.setText(game.getBoardSpot(1, 2));
//		spot11.setText(game.getBoardSpot(1, 3));
//		spot12.setText(game.getBoardSpot(1, 4));
//		spot13.setText(game.getBoardSpot(1, 5));
//		spot14.setText(game.getBoardSpot(1, 6));
//		spot15.setText(game.getBoardSpot(2, 0));
//		spot16.setText(game.getBoardSpot(2, 1));
//		spot17.setText(game.getBoardSpot(2, 2));
//		spot18.setText(game.getBoardSpot(2, 3));
//		spot19.setText(game.getBoardSpot(2, 4));
//		spot20.setText(game.getBoardSpot(2, 5));
//		spot21.setText(game.getBoardSpot(2, 6));
//		spot22.setText(game.getBoardSpot(3, 0));
//		spot23.setText(game.getBoardSpot(3, 1));
//		spot24.setText(game.getBoardSpot(3, 2));
//		spot25.setText(game.getBoardSpot(3, 3));
//		spot26.setText(game.getBoardSpot(3, 4));
//		spot27.setText(game.getBoardSpot(3, 5));
//		spot28.setText(game.getBoardSpot(3, 6));
//		spot29.setText(game.getBoardSpot(4, 0));
//		spot30.setText(game.getBoardSpot(4, 1));
//		spot31.setText(game.getBoardSpot(4, 2));
//		spot32.setText(game.getBoardSpot(4, 3));
//		spot33.setText(game.getBoardSpot(4, 4));
//		spot34.setText(game.getBoardSpot(4, 5));
//		spot35.setText(game.getBoardSpot(4, 6));
//		spot36.setText(game.getBoardSpot(5, 0));
//		spot37.setText(game.getBoardSpot(5, 1));
//		spot38.setText(game.getBoardSpot(5, 2));
//		spot39.setText(game.getBoardSpot(5, 3));
//		spot40.setText(game.getBoardSpot(5, 4));
//		spot41.setText(game.getBoardSpot(5, 5));
//		spot42.setText(game.getBoardSpot(5, 6));
	}
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int col = Integer.parseInt(((AbstractButton) e.getSource()).getName());
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
				}
				else if(game.gameOver() == 2) {
					label.setText("The game ends in a tie");
				}
			}
		}
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
		
//		button1.setEnabled(false);
//		button2.setEnabled(false);
//		button3.setEnabled(false);
//		button4.setEnabled(false);
//		button5.setEnabled(false);
//		button6.setEnabled(false);
//		button7.setEnabled(false);
	}
}
