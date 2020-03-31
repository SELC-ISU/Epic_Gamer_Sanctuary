package tictactoe;
import java.util.Scanner;

public class TicTacToe_Test {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();

		Scanner s = new Scanner(System.in);
		int spot;
		int x, y;
		int gameStatus = 0;
		
		while(gameStatus == 0) {
			System.out.println(game.getBoardStr());
			System.out.println("Player " + game.getTurn() + " where would you like to play? (spot 1-9) ");
			spot = s.nextInt();
			spot--;
			x = spot % 3;
			y = spot / 3;
			
			game.move(game.getTurn(), x, y);
			gameStatus = game.gameOver();
		}
		
		
		if(gameStatus == 1) {
			System.out.println("GAME OVER! Player " + game.whoWon() + " won!");
			System.out.println(game.getBoardStr());
		}
		else {
			System.out.println("The game is a tie!");
		}
			
		s.close();
	}
}
