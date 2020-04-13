package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Yahtzee_GUI {

	int rollsRemaining;
	int roundNum;
	
	JFrame frame;
	
	JButton start;
	/*
	JButton disableDice1, disableDice2, disableDice3, disableDice4, disableDice5, rollAgain;
	JButton score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13;
	*/
	JButton rollAgain;
	JButton[] disableButtons;
	JButton[] scoreButtons;

	
	//JLabel dice1, dice2, dice3, dice4, dice5;
	
	JLabel directions, rollsLeft, round;
	JLabel[] diceLabels;
	
	/*
	JLabel scorecard, scorecard1, scorecard2, scorecard3, scorecard4, scorecard5, scorecard6, scorecardUpper;
	JLabel scorecard7, scorecard8, scorecard9, scorecard10, scorecard11, scorecard12, scorecard13, scorecardLower, scorecardGrand;
	JLabel scoreUpperTotal, scoreLowerTotal, scoreGrandTotal;
	*/
	
	JLabel scorecardTitle, scoreUpperValue, scoreLowerValue, scoreGrandValue;
	JLabel[] scorecardLabels;
	
	JLabel gameOver, restart;
	
	//JPanel panelGamePlay, panelDiceRow1, panelDiceRow2, panelDice1, panelDice2, panelDice3, panelDice4, panelDice5, panelDiceDirections; 
	
	// maybe change panelDiceRows into array?
	JPanel panelGamePlay, panelDiceRow1, panelDiceRow2, panelDiceDirections;
	JPanel[] dicePanels;
	
	/*
	JPanel panelScorecard, panelScoreRow1, panelScoreRow2, panelScoreRow3, panelScoreRow4, panelScoreRow5, panelScoreRow6, panelScoreUpperTotal;
	JPanel panelScoreRow7, panelScoreRow8, panelScoreRow9, panelScoreRow10, panelScoreRow11, panelScoreRow12, panelScoreRow13, panelScoreLowerTotal, panelScoreGrandTotal;
	*/
	JPanel panelScorecard;
	JPanel[] scorecardRowPanels;
	
	JPanel panelEndGame;
	
	Yahtzee game;
	
	public Yahtzee_GUI() {
		
		disableButtons = new JButton[5];
		scoreButtons = new JButton[13];
		
		diceLabels = new JLabel[5];
		scorecardLabels = new JLabel[16];
		
		dicePanels = new JPanel[5];
		scorecardRowPanels = new JPanel[16];
		
		game = new Yahtzee();
		
		frame = new JFrame("Yahtzee");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500,650);
		
		start = new JButton("START");
		
		// 
		initGamePlayJLabels();
		initGamePlayJButtons();
		
		initGamePlayPanels();
		fillGamePlayPanels();
		
		
		// setup scorecard
		initScorecardJLabel();
		initScorecardJButton();

		initScorecardPanels();
		fillScorecardPanels();
		
		// 
		setButtonNames();
		initAllButtonActionListeners();
		
		disableAllButtons();
		
		frame.add(panelGamePlay);
		frame.add(panelScorecard, BorderLayout.LINE_END);
		frame.add(start, BorderLayout.PAGE_START);
		
		frame.setVisible(true);

	}

	private void disableAllButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setEnabled(false);
		}
		/*
		disableDice1.setEnabled(false);
		disableDice2.setEnabled(false);
		disableDice3.setEnabled(false);
		disableDice4.setEnabled(false);
		disableDice5.setEnabled(false);
		*/
		rollAgain.setEnabled(false);
		
		disableScoreButtons();
	}

	private void fillGamePlayPanels() {
		for(int i = 0; i < dicePanels.length; i++) {
			dicePanels[i].add(diceLabels[i]);
			dicePanels[i].add(disableButtons[i]);
		}
		/*
		panelDice1.add(dice1);
		panelDice1.add(disableDice1);
		panelDice2.add(dice2);
		panelDice2.add(disableDice2);
		panelDice3.add(dice3);
		panelDice3.add(disableDice3);
		panelDice4.add(dice4);
		panelDice4.add(disableDice4);
		panelDice5.add(dice5);
		panelDice5.add(disableDice5);
		*/
		
		panelDiceRow1.add(dicePanels[0]);
		panelDiceRow1.add(dicePanels[1]);
		panelDiceRow1.add(dicePanels[2]);
		panelDiceRow2.add(dicePanels[3]);
		panelDiceRow2.add(dicePanels[4]);
		
		panelDiceDirections.add(rollAgain);
		panelDiceDirections.add(rollsLeft);
		
		panelGamePlay.add(round);
		panelGamePlay.add(panelDiceRow1);
		panelGamePlay.add(panelDiceRow2);
		//panelGamePlay.add(directions);
		panelGamePlay.add(panelDiceDirections);
	}

	private void initGamePlayPanels() {
		panelGamePlay = new JPanel();
		panelGamePlay.setLayout(new BoxLayout(panelGamePlay, BoxLayout.Y_AXIS));
		
		panelDiceRow1 = new JPanel();
		panelDiceRow2 = new JPanel();
		//panelDice.setLayout(new BoxLayout(panelDice, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < dicePanels.length; i++) {
			dicePanels[i] = new JPanel();
			dicePanels[i].setLayout(new BoxLayout(dicePanels[i], BoxLayout.Y_AXIS));
		}
		/*
		panelDice1 = new JPanel();
		panelDice1.setLayout(new BoxLayout(panelDice1, BoxLayout.Y_AXIS));
		panelDice2 = new JPanel();
		panelDice2.setLayout(new BoxLayout(panelDice2, BoxLayout.Y_AXIS));
		panelDice3 = new JPanel();
		panelDice3.setLayout(new BoxLayout(panelDice3, BoxLayout.Y_AXIS));
		panelDice4 = new JPanel();
		panelDice4.setLayout(new BoxLayout(panelDice4, BoxLayout.Y_AXIS));
		panelDice5 = new JPanel();
		panelDice5.setLayout(new BoxLayout(panelDice5, BoxLayout.Y_AXIS));
		*/
		panelDiceDirections = new JPanel();
	}

	private void initGamePlayJButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i] = new JButton("Rolling");
		}
		/*
		disableDice1 = new JButton("disable");
		disableDice2 = new JButton("disable");
		disableDice3 = new JButton("disable");
		disableDice4 = new JButton("disable");
		disableDice5 = new JButton("disable");
		*/
		rollAgain = new JButton("Roll Again");
	}

	private void initGamePlayJLabels() {
		for(int i = 0; i < diceLabels.length; i++) {
			diceLabels[i] = new JLabel(game.getDiceNum(i) + "");
			diceLabels[i].setFont(new Font("Tahoma", Font.BOLD, 100));
		}
		/*
		dice1 = new JLabel(game.getDiceNum(0) + "");
		dice2 = new JLabel(game.getDiceNum(1) + "");
		dice3 = new JLabel(game.getDiceNum(2) + "");
		dice4 = new JLabel(game.getDiceNum(3) + "");
		dice5 = new JLabel(game.getDiceNum(4) + "");
		
		dice1.setFont(new Font("Tahoma", Font.BOLD, 100));
		dice2.setFont(new Font("Tahoma", Font.BOLD, 100));
		dice3.setFont(new Font("Tahoma", Font.BOLD, 100));
		dice4.setFont(new Font("Tahoma", Font.BOLD, 100));
		dice5.setFont(new Font("Tahoma", Font.BOLD, 100));
		*/
		round = new JLabel("Round: " + roundNum);
		round.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		directions = new JLabel("Click the buttons on the dice to disable/enable a roll\nThen click the re-roll button");
		rollsLeft = new JLabel("Rolls Left: " + rollsRemaining);
	}

	private void fillScorecardPanels() {
		for(int i = 0; i < 6; i++) {
			scorecardRowPanels[i].add(scorecardLabels[i]);
			scorecardRowPanels[i].add(scoreButtons[i]);
		}
		/*
		panelScoreRow1.add(scorecard1);
		panelScoreRow1.add(score1);
		panelScoreRow2.add(scorecard2);
		panelScoreRow2.add(score2);
		panelScoreRow3.add(scorecard3);
		panelScoreRow3.add(score3);
		panelScoreRow4.add(scorecard4);
		panelScoreRow4.add(score4);
		panelScoreRow5.add(scorecard5);
		panelScoreRow5.add(score5);
		panelScoreRow6.add(scorecard6);
		panelScoreRow6.add(score6);
		*/
		scorecardRowPanels[6].add(scorecardLabels[6]);
		scorecardRowPanels[6].add(scoreUpperValue);
		/*
		panelScoreUpperTotal.add(scorecardUpper);
		panelScoreUpperTotal.add(scoreUpperTotal);
		*/
		/****
		 * Not sure about alignment
		 */
		for(int i = 7; i <= 13; i++) {
			scorecardRowPanels[i].add(scorecardLabels[i]);
			scorecardRowPanels[i].add(scoreButtons[i-1]);
		}
		/*
		panelScoreRow7.add(scorecard7);
		panelScoreRow7.add(score7);
		panelScoreRow8.add(scorecard8);
		panelScoreRow8.add(score8);
		panelScoreRow9.add(scorecard9);
		panelScoreRow9.add(score9);
		panelScoreRow10.add(scorecard10);
		panelScoreRow10.add(score10);
		panelScoreRow11.add(scorecard11);
		panelScoreRow11.add(score11);
		panelScoreRow12.add(scorecard12);
		panelScoreRow12.add(score12);
		panelScoreRow13.add(scorecard13);
		panelScoreRow13.add(score13);
		*/
		scorecardRowPanels[14].add(scorecardLabels[14]);
		scorecardRowPanels[14].add(scoreLowerValue);
		scorecardRowPanels[15].add(scorecardLabels[15]);
		scorecardRowPanels[15].add(scoreGrandValue);
		/*
		panelScoreLowerTotal.add(scorecardLower);
		panelScoreLowerTotal.add(scoreLowerTotal);
		panelScoreGrandTotal.add(scorecardGrand);
		panelScoreGrandTotal.add(scoreGrandTotal);
		*/
		panelScorecard.add(scorecardTitle);
		for(int i = 0; i < scorecardRowPanels.length; i++) {
			panelScorecard.add(scorecardRowPanels[i]);
		}
 		/*
		panelScorecard.add(scorecard);
		panelScorecard.add(panelScoreRow1);
		panelScorecard.add(panelScoreRow2);
		panelScorecard.add(panelScoreRow3);
		panelScorecard.add(panelScoreRow4);
		panelScorecard.add(panelScoreRow5);
		panelScorecard.add(panelScoreRow6);
		panelScorecard.add(panelScoreUpperTotal);
		panelScorecard.add(panelScoreRow7);
		panelScorecard.add(panelScoreRow8);
		panelScorecard.add(panelScoreRow9);
		panelScorecard.add(panelScoreRow10);
		panelScorecard.add(panelScoreRow11);
		panelScorecard.add(panelScoreRow12);
		panelScorecard.add(panelScoreRow13);
		panelScorecard.add(panelScoreLowerTotal);
		panelScorecard.add(panelScoreGrandTotal);
		*/
	}

	private void initScorecardPanels() {
		panelScorecard = new JPanel();
		panelScorecard.setLayout(new BoxLayout(panelScorecard, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < scorecardRowPanels.length; i++) {
			scorecardRowPanels[i] = new JPanel();
		}
		/*
		panelScoreRow1 = new JPanel();
		panelScoreRow2 = new JPanel();
		panelScoreRow3 = new JPanel();
		panelScoreRow4 = new JPanel();
		panelScoreRow5 = new JPanel();
		panelScoreRow6 = new JPanel();
		panelScoreUpperTotal = new JPanel();
		panelScoreRow7 = new JPanel();
		panelScoreRow8 = new JPanel();
		panelScoreRow9 = new JPanel();
		panelScoreRow10 = new JPanel();
		panelScoreRow11 = new JPanel();
		panelScoreRow12 = new JPanel();
		panelScoreRow13 = new JPanel();
		panelScoreLowerTotal = new JPanel();
		panelScoreGrandTotal = new JPanel();
		*/
	}

	private void initAllButtonActionListeners() {
		start.addActionListener(new ButtonActionListener());
		
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].addActionListener(new ButtonActionListener());
		}
		/*
		disableDice1.addActionListener(new ButtonActionListener());
		disableDice2.addActionListener(new ButtonActionListener());
		disableDice3.addActionListener(new ButtonActionListener());
		disableDice4.addActionListener(new ButtonActionListener());
		disableDice5.addActionListener(new ButtonActionListener());
		*/
		rollAgain.addActionListener(new ButtonActionListener());
		
		for(int i=0; i<scoreButtons.length; i++) {
			scoreButtons[i].addActionListener(new ButtonActionListener());
		}
		/*
		score1.addActionListener(new ButtonActionListener());
		score2.addActionListener(new ButtonActionListener());
		score3.addActionListener(new ButtonActionListener());
		score4.addActionListener(new ButtonActionListener());
		score5.addActionListener(new ButtonActionListener());
		score6.addActionListener(new ButtonActionListener());
		score7.addActionListener(new ButtonActionListener());
		score8.addActionListener(new ButtonActionListener());
		score9.addActionListener(new ButtonActionListener());
		score10.addActionListener(new ButtonActionListener());
		score11.addActionListener(new ButtonActionListener());
		score12.addActionListener(new ButtonActionListener());
		score13.addActionListener(new ButtonActionListener());
		*/
	}

	private void setButtonNames() {
		for(int i = 0; i < scoreButtons.length; i++) {
			scoreButtons[i].setName(i+1 + "");
		}
		/*
		score1.setName("1");
		score2.setName("2");
		score3.setName("3");
		score4.setName("4");
		score5.setName("5");
		score6.setName("6");
		score7.setName("7");
		score8.setName("8");
		score9.setName("9");
		score10.setName("10");
		score11.setName("11");
		score12.setName("12");
		score13.setName("13");
		*/
		rollAgain.setName("20");
		
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setName(i+31 + "");
		}
		/*
		disableDice1.setName("31");
		disableDice2.setName("32");
		disableDice3.setName("33");
		disableDice4.setName("34");
		disableDice5.setName("35");
		*/
		start.setName("40");
	}

	private void initScorecardJButton() {
		for(int i = 0; i < scoreButtons.length; i++) {
			scoreButtons[i] = new JButton("score");
		}
		/*
		score1 = new JButton("score");
		score2 = new JButton("score");
		score3 = new JButton("score");
		score4 = new JButton("score");
		score5 = new JButton("score");
		score6 = new JButton("score");
		score7 = new JButton("score");
		score8 = new JButton("score");
		score9 = new JButton("score");
		score10 = new JButton("score");
		score11 = new JButton("score");
		score12 = new JButton("score");
		score13 = new JButton("score");
		*/
	}

	private void initScorecardJLabel() {
		scorecardTitle = new JLabel("Scorecard");
		scorecardTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		scorecardLabels[0] = new JLabel("  One's   ");
		scorecardLabels[1] = new JLabel("  Two's   ");
		scorecardLabels[2] = new JLabel("  Three's ");
		scorecardLabels[3] = new JLabel("  Four's  ");
		scorecardLabels[4] = new JLabel("  Five's  ");
		scorecardLabels[5] = new JLabel("  Six's   ");
		scorecardLabels[6] = new JLabel("Upper Total ");
		scorecardLabels[6].setFont(new Font("Tahoma", Font.BOLD, 13));
		scorecardLabels[7] = new JLabel("  3 of a Kind ");
		scorecardLabels[8] = new JLabel("  4 of a Kind ");
		scorecardLabels[9] = new JLabel("  Full House  ");
		scorecardLabels[10] = new JLabel("  Sm Straight ");
		scorecardLabels[11] = new JLabel("  Lg Straight ");
		scorecardLabels[12] = new JLabel("  Yahtzee     ");
		scorecardLabels[13] = new JLabel("  Chance      ");
		scorecardLabels[14] = new JLabel("Lower Total ");
		scorecardLabels[14].setFont(new Font("Tahoma", Font.BOLD, 13));
		scorecardLabels[15] = new JLabel("Grand Total ");
		scorecardLabels[15].setFont(new Font("Tahoma", Font.BOLD, 17));
		/*
		// push button, button holds value, disables, font bold
		scorecard = new JLabel("Scorecard");
		scorecard.setFont(new Font("Tahoma", Font.BOLD, 20));
		scorecard1 = new JLabel("  One's   ");
		scorecard2 = new JLabel("  Two's   ");
		scorecard3 = new JLabel("  Three's ");
		scorecard4 = new JLabel("  Four's  ");
		scorecard5 = new JLabel("  Five's  ");
		scorecard6 = new JLabel("  Six's   ");
		scorecardUpper = new JLabel("Upper Total ");
		scorecardUpper.setFont(new Font("Tahoma", Font.BOLD, 13));
		scorecard7 = new JLabel("  3 of a Kind ");
		scorecard8 = new JLabel("  4 of a Kind ");
		scorecard9 = new JLabel("  Full House  ");
		scorecard10 = new JLabel("  Sm Straight ");
		scorecard11 = new JLabel("  Lg Straight ");
		scorecard12 = new JLabel("  Yahtzee     ");
		scorecard13 = new JLabel("  Chance      ");
		scorecardLower = new JLabel("Lower Total ");
		scorecardLower.setFont(new Font("Tahoma", Font.BOLD, 13));
		scorecardGrand = new JLabel("Grand Total ");
		scorecardGrand.setFont(new Font("Tahoma", Font.BOLD, 17));
		*/
		scoreUpperValue = new JLabel(game.getUpperSection() + "");
		scoreLowerValue = new JLabel(game.getLowerSection() + "");
		scoreGrandValue = new JLabel(game.getGrandTotal() + "");
	}


	
	
	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(((AbstractButton) e.getSource()).getName());
			
			// start
			if(id == 40) {
				if(roundNum > 13) {
					frame.remove(panelEndGame);
					frame.add(panelGamePlay);
					game = new Yahtzee();
					resetLabelText();
					scoreUpperValue.setText(game.getUpperSection() + "");
					scoreLowerValue.setText(game.getLowerSection() + "");
					scoreGrandValue.setText(game.getGrandTotal() + "");
				}
				
				roundNum = 1;
				rollsRemaining = 2;
				
				round.setText("Round: " + roundNum);
				rollsLeft.setText("Rolls Left: " + rollsRemaining);
				
				game.roll();
				
				updateDice();
				
				enableAllButtons();
				
				frame.remove(start);
			}
			// roll again
			else if(id == 20) {
				game.roll();
				
				if(rollsRemaining == 3) {
					enableDisableButtons();
				}
				
				rollsRemaining--;
				
				updateDice();
				rollsLeft.setText("Rolls Left: " + rollsRemaining);
				
				if(rollsRemaining == 0) {
					rollAgain.setEnabled(false);
					
					disableDisableButtons();
				}
				
				enableScoreButtons();
			}
			// disables
			else if(31 <= id && id <=35) {
				id -= 31;
				game.disable(id);

				String text = ((AbstractButton) e.getSource()).getText();
				if(text.contains("Rolling")) {
					((AbstractButton) e.getSource()).setText("Holding");
				}
				else {
					((AbstractButton) e.getSource()).setText("Rolling");
				}
			}
			// scores
			else if(1 <= id && id <= 13) {
				game.score(id);
				
				if(id < 7) {
					scoreUpperValue.setText(game.getUpperSection() + "");
				}
				else {
					scoreLowerValue.setText(game.getLowerSection() + "");
				}
				scoreGrandValue.setText(game.getGrandTotal() + "");
				
				disableScoreButtons();
				
				((AbstractButton) e.getSource()).setText(game.getScorecard(id-1) + "");
				
				resetDisableButtons();
				
				rollAgain.setEnabled(true);
				rollsRemaining = 3;
				rollsLeft.setText("Press button to roll again");
				
				roundNum++;
				if(roundNum > 13) {
					endGame();
				}
				round.setText("Round: " + roundNum);
				
			}
		}

	}
	
	private void enableDisableButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setEnabled(true);
		}
	}
	
	private void disableDisableButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setEnabled(false);
		}
	}
	
	public void updateDice() {
		for(int i = 0; i < diceLabels.length; i++) {
			diceLabels[i].setText(game.getDiceNum(i) + "");
		}
		/*
		dice1.setText(game.getDiceNum(0) + "");
		dice2.setText(game.getDiceNum(1) + "");
		dice3.setText(game.getDiceNum(2) + "");
		dice4.setText(game.getDiceNum(3) + "");
		dice5.setText(game.getDiceNum(4) + "");
		*/
	}
	
	public void resetLabelText() {
		round.setText("Round: " + roundNum);
		
		for(int i = 0; i < scoreButtons.length; i++) {
			scoreButtons[i].setText("score");
		}
		/*
		score1.setText("score");
		score2.setText("score");
		score3.setText("score");
		score4.setText("score");
		score5.setText("score");
		score6.setText("score");
		score7.setText("score");
		score8.setText("score");
		score9.setText("score");
		score10.setText("score");
		score11.setText("score");
		score12.setText("score");
		score13.setText("score");
		*/
	}

	public void endGame() {
		disableAllButtons();
		
		gameOver = new JLabel("GAME OVER!");
		gameOver.setFont(new Font("Tahoma", Font.BOLD, 40));
		restart = new JLabel("Press Start Button to Begin a New Game");
		restart.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		panelEndGame = new JPanel();
		panelEndGame.setLayout(new BoxLayout(panelEndGame, BoxLayout.Y_AXIS));
		
		panelEndGame.add(gameOver);
		panelEndGame.add(restart);
		
		frame.remove(panelGamePlay);
		frame.add(panelEndGame);
		frame.add(start, BorderLayout.PAGE_START);
	}

	public void resetDisableButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setText("Rolling");
		}
		/*
		disableDice1.setText("disable");
		disableDice2.setText("disable");
		disableDice3.setText("disable");
		disableDice4.setText("disable");
		disableDice5.setText("disable");
		*/
	}
	
	public void enableScoreButtons() {
		//JButton[] scoreButtons = {score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13};
		
		for(int i = 0; i < scoreButtons.length; i++) {
			if(scoreButtons[i].getText().contentEquals("score")) {
				scoreButtons[i].setEnabled(true);
			}
		}
	}

	public void disableScoreButtons() {
		for(int i = 0; i < scoreButtons.length; i++) {
			scoreButtons[i].setEnabled(false);
		}
		/*
		score1.setEnabled(false);
		score2.setEnabled(false);
		score3.setEnabled(false);
		score4.setEnabled(false);
		score5.setEnabled(false);
		score6.setEnabled(false);
		score7.setEnabled(false);
		score8.setEnabled(false);
		score9.setEnabled(false);
		score10.setEnabled(false);
		score11.setEnabled(false);
		score12.setEnabled(false);
		score13.setEnabled(false);
		*/
	}

	public void enableAllButtons() {
		for(int i = 0; i < disableButtons.length; i++) {
			disableButtons[i].setEnabled(true);
		}
		/*
		disableDice1.setEnabled(true);
		disableDice2.setEnabled(true);
		disableDice3.setEnabled(true);
		disableDice4.setEnabled(true);
		disableDice5.setEnabled(true);
		*/
		rollAgain.setEnabled(true);
		
		enableScoreButtons();
	}

	public static void main(String[] args) {
		Yahtzee_GUI test = new Yahtzee_GUI();
	}
}