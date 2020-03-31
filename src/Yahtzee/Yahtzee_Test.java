package Yahtzee;

import java.util.Arrays;

public class Yahtzee_Test {
	public static void main(String[] args) {
		/*
		Yahtzee game = new Yahtzee();
		game.enableTestPrint();
		for(int i = 0; i < 13; i++) {
			game.round();
		}
		*/
		
		int[] dice = {5,4,3,2,1};
		
		for(int i = 0; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				if(dice[j] < dice[j-1]) {
					int temp = dice[j-1];
					dice[j-1] = dice[j];
					dice[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(dice));
	}
}
