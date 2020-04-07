package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Yahtzee_GUI {

	JFrame frame;
	JButton dice1, dice2, dice3, dice4, dice5, rollAgain;
	JButton score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13;
	JLabel label, scorecard;
	JPanel panel1, panel2;
	Yahtzee game;
	
	public Yahtzee_GUI() {
		
		game = new Yahtzee();
		
		
		frame = new JFrame("Yahtzee");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300,300);
		
		label = new JLabel("Player it is your turn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		dice1 = new JButton("disable");
		dice2 = new JButton("disable");
		dice3 = new JButton("disable");
		dice4 = new JButton("disable");
		dice5 = new JButton("disable");
		
		rollAgain = new JButton("Roll Again");
		
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
		
		rollAgain.setName("20");
		
		dice1.setName("31");
		dice2.setName("32");
		dice3.setName("33");
		dice4.setName("34");
		dice5.setName("35");
		
		
		dice1.addActionListener(new ButtonActionListener());
		dice2.addActionListener(new ButtonActionListener());
		dice3.addActionListener(new ButtonActionListener());
		dice4.addActionListener(new ButtonActionListener());
		dice5.addActionListener(new ButtonActionListener());
		rollAgain.addActionListener(new ButtonActionListener());
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

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 3));
		
		panel2.add(dice1);

		
		panel1.add(label);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel2, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		
		
	}


	public class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}