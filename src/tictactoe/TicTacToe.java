package tictactoe;

public class TicTacToe {
	
	private int turn;
	private char[][] board = new char[3][3];
	private boolean[][] highlights = new boolean[3][3];
	
	public TicTacToe() {
		turn = 1;
		
		// fill board
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = '*';
			}
		}
		
	}
	
	public boolean move(int player, int xSpot, int ySpot) {
		if(player == turn) {
			if(board[ySpot][xSpot] == '*') {
				if(turn == 1) {
					board[ySpot][xSpot] = 'X';
				}
				else {
					board[ySpot][xSpot] = 'O';
				}
				
				if(turn == 1) {
					turn = 2;
				}
				else if(turn == 2) {
					turn = 1;
				}
				
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public int gameOver() {
		char c;
		
		//check horizontal
		for(int i = 0; i < board.length; i++) {
			if(board[i][0] != '*') {
				c = board[i][0];
				int count = 0;
				
				for(int j = 0; j < board[0].length; j++) {
					if(board[i][j] == c) {
						count++;
					}
				}
				
				if(count == 3) {
					highlightWin(i, 0, 1);
					return 1;
				}
			}
		}
		
		//check vertial
		for(int j = 0; j < board[0].length; j++) {
			if(board[0][j] != '*') {
				c = board[0][j];
				int count = 0;
				
				for(int i = 0; i < board.length; i++) {
					if(board[i][j] == c) {
						count++;
					}
				}
				
				if(count == 3) {
					highlightWin(0, j, 2);
					return 1;
				}
			}
		}
		
		//check diagonal
		if(board[0][0] != '*') {
			c = board[0][0];
			int count = 0;
			for(int k = 0; k < 3; k++) {
				if(board[k][k] == c) {
					count++;
				}
			}
			if(count == 3) {
				highlightWin(0, 0, 3);
				return 1;
			}
		}
			
		//check other diagonal
		if(board[0][2] != '*') {
			c = board[0][2];
			int count = 0;
			for(int k = 0; k < 3; k++) {
				if(board[k][2-k] == c) {
					count++;
				}
			}
			if(count == 3) {
				highlightWin(0, 2, 4);
				return 1;
			}
		}
		
		// checking for CAT game
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '*') {
					return 0;
				}
			}
		}
		
		// tied CAT game
		return 2;
	}
	
	private void highlightWin(int x, int y, int dir) {
		if(dir == 1) {
			for(int i = 0; i < 3; i++) {
				highlights[x][y+i] = true;
			}
		}
		else if(dir == 2) {
			for(int i = 0; i < 3; i++) {
				highlights[x+i][y] = true;
			}
		}
		else if(dir == 3) {
			for(int i = 0; i < 3; i++) {
				highlights[x+i][y+i] = true;
			}
		}
		else if(dir == 4) {
			for(int i = 0; i < 3; i++) {
				highlights[x+i][y-i] = true;
			}
		}
	}
	
	public boolean getHighlight(int x, int y) {
		return highlights[x][y];
	}
	
	public int whoWon() {
		if(turn == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	
	public String getBoardSpot(int y, int x) {
		return board[y][x] + "";
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	
	//Use for testing, might not need in real game
	public String getBoardStr() {
		String str = "";
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				str += board[i][j];
			}
			str += "\n";
		}
		return str;
	}
	
	public int getTurn() {
		return turn;
	}
}