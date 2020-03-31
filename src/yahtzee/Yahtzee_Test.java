package yahtzee;

import java.util.Arrays;

public class Yahtzee_Test {
	public static void main(String[] args) {
		
		Yahtzee game = new Yahtzee();
		game.enableTestPrint();
		for(int i = 0; i < 13; i++) {
			game.round();
		}
		
	}
}
