package yahtzee;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
	
	private int[] dice;
	private boolean[] toRoll;
	
	private int round;
	
	private int[] scorecard;
	
	private boolean testPrint;
	
	public Yahtzee() {
		dice = new int[5];
		toRoll = new boolean[5];
		for(int i = 0; i < 5; i++) {
			toRoll[i] = true;
		}
		round = 1;
		scorecard = new int[13];
		
		testPrint = false;
	}
	
	
	public int getDiceNum(int diceNum) {
		return dice[diceNum];
	}
	
	public int getDiceTotal() {
		int total = 0;
		for(int i = 0;i < 5; i++) {
			total += dice[i];
		}
		return total;
	}
	
	public boolean[] getToRoll() {
		return toRoll;
	}
	
	public int getScorecard(int row) {
		return scorecard[row];
	}
	
	public int getUpperSection() {
		int total = 0;
		for(int i = 0; i < 6; i++) {
			total += scorecard[i];
		}
		if(total >= 63) {
			total += 35;
		}
		
		return total;
	}
	
	public int getLowerSection() {
		int total = 0;
		for(int i = 6; i < 13; i++) {
			total += scorecard[i];
		}
		
		return total;
	}
	
	public int getGrandTotal() {
		return getUpperSection() + getLowerSection();
	}
	
	public String printScorecard() {
		String card = "";
		card += "Ones: " + scorecard[0] + "\n";
		card += "Twos: " + scorecard[1] + "\n";
		card += "Threes: " + scorecard[2] + "\n";
		card += "Fours: " + scorecard[3] + "\n";
		card += "Fives: " + scorecard[4] + "\n";
		card += "Sixes: " + scorecard[5] + "\n";
		card += "Upper Total: " + getUpperSection() + "\n\n";
		
		card += "Three of a Kind: " + scorecard[6] + "\n";
		card += "Four of a Kind: " + scorecard[7] + "\n";
		card += "Full House: " + scorecard[8] + "\n";
		card += "Small Straight: " + scorecard[9] + "\n";
		card += "Large Straight: " + scorecard[10] + "\n";
		card += "Yahtzee: " + scorecard[11] + "\n";
		card += "Chance: " + scorecard[12] + "\n";
		card += "Lower Total: " + getLowerSection() + "\n\n";
		
		card += "Grand Total: " + getGrandTotal();
		
		return card;
	}
	
	public String printDice() {
		return Arrays.toString(dice);
	}
	
	/*
	public void enableTestPrint() {
		testPrint = true;
	}
	
	public void round() {				
		roll();
		System.out.println(printDice());
		System.out.println(Arrays.toString(toRoll));
		disable();
		
		roll();
		System.out.println(printDice());
		System.out.println(Arrays.toString(toRoll));
		disable();
		
		roll();
		System.out.println(printDice());
		
		score();
		
		round++;
		
		dice = new int[5];
		toRoll = new boolean[5];
		for(int i = 0; i < 5; i++) {
			toRoll[i] = true;
		}
		
		if(round == 13) {
			endGame();
		}
	}
	*/
	
	public void roll() {
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			if(toRoll[i] == true) {
				dice[i] = rand.nextInt(6) + 1;
			}
		}
		

	}
	
	/*
	public void disable() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What dice to not roll again? ");
		String s = scan.nextLine();
		Scanner scan2 = new Scanner(s);
		
		//System.out.println(s);
		
		while(scan2.hasNextInt()) {
			int value = scan2.nextInt() - 1;
			if(value < 0) {
				break;
			}
			else {
				switchToRoll(value);
			}
		}
		
		//scan.close();
		//scan2.close();
	}
	*/
	
	public void disable(int num) {
		if(toRoll[num] == true) {
			toRoll[num] = false;
		}
		else {
			toRoll[num] = true;
		}
	}
	
	private void endGame() {
		if(testPrint) {
			System.out.println(printScorecard());
		}
		System.exit(0);
	}
	
	public void score(int spot) {
		/*
		Scanner scan = new Scanner(System.in);
		System.out.println("Where to score this roll? (1-13) ");
		int spot = scan.nextInt();
		*/
		
		switch(spot) {
		//Upper Section
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				for(int i = 0; i < 5; i++) {
					if(dice[i] == spot) {
						scorecard[spot-1] += dice[i];
					}
				}
				break;
		//Lower Section
			case 7:
				if(isThreeOfAKind()) {
					scorecard[6] = getDiceTotal();
				}
				break;
			case 8:
				if(isFourOfAKind()) {
					scorecard[7] = getDiceTotal();
				}
				break;
			case 9:
				if(isFullHouse()) {
					scorecard[8] = 25;
				}
				break;
			case 10:
				if(isSmallStraight()) {
					scorecard[9] = 30;
				}
				break;
			case 11:
				if(isLargeStraight()) {
					scorecard[10] = 40;
				}
				break;
			case 12:
				if(isYahtzee()) {
					scorecard[11] = 50;
				}
				break;
			case 13: 
				scorecard[12] = getDiceTotal();
				break;
			default:
				System.out.println("ERROR");
		}
		
		//scan.close();
		
		//System.out.println("Line score: " + scorecard[spot-1] + "\n");
		
		dice = new int[5];
		toRoll = new boolean[5];
		for(int i = 0; i < 5; i++) {
			toRoll[i] = true;
		}
	}


	private boolean isYahtzee() {
		int compare = dice[0];
		for(int i = 1; i < 5; i++) {
			if(dice[i] != compare) {
				return false;
			}
		}
		return true;
	}


	private boolean isLargeStraight() {
		sortDice();
		
		for(int i = 0; i < 4; i++) {
			if(dice[i] + 1 != dice[i+1]) {
				return false;
			}
		}
		
		return true;
	}


	private boolean isSmallStraight() {
		sortDice();
		
		singleSortDice();
		
		boolean result = true;
		
		for(int i = 0; i < 3; i++) {
			if(dice[i]+1 != dice[i+1]) {
				result = false;
				break;
			}
		}
		
		if(!result) {
			result = true;
			for(int i = 1; i < 4; i++) {
				if(dice[i]+1 != dice[i+1]) {
					result = false;
				}
			}
		}
		
		
		return result;
	}
	
	// input is ordered dice, if there is a repeating number move it to the end of the array
	private void singleSortDice() {
		for(int i = 0; i < dice.length-1; i++) {
			if(dice[i] == dice[i+1]) {
				int temp = dice[i];
				for(int j = i; j < dice.length-1; j++) {
					dice[j] = dice[j+1];
				}
				dice[dice.length-1] = temp;
			}
		}
	}


	private void sortDice() {
		for(int i = 0; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				if(dice[j] < dice[j-1]) {
					int temp = dice[j-1];
					dice[j-1] = dice[j];
					dice[j] = temp;
				}
			}
		}
	}


	private boolean isFullHouse() {
		sortDice();
		return (dice[0] == dice[1] && dice[3] == dice[4] && (dice[2] == dice[1] || dice[2] == dice[3]));
	}


	private boolean isFourOfAKind() {
		sortDice();
		return dice[0] == dice[3] || dice[1] == dice[4];
	}


	private boolean isThreeOfAKind() {
		sortDice();
		return dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4];
	}
}
