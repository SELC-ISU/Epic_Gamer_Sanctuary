package connectfour;
import java.util.Scanner;

public class ConnectFourTest {

	public static void main(String[] args) {
		ConnectFour game = new ConnectFour();
		
		Scanner scan = new Scanner(System.in);
		
		int gameStatus = 0;
		int column;
				
		System.out.println(game.getBoardStr());
		
		while(gameStatus == 0) {
			System.out.println("Player " + game.getTurn() + " where would you like to play? (column 1-7) ");
			column = scan.nextInt();
			column--;
			
			game.move(game.getTurn(), column);
			
			System.out.println(game.getBoardStr());

			gameStatus = game.gameOver();
		}
		
		if(gameStatus == 1) {
			System.out.println("GAME OVER! Player " + game.whoWon() + " won!");
			System.out.println(game.getBoardStr());
		}
		else {
			System.out.println("The game is a tie!");
		}
		
		scan.close();
	}
}
