package connectfour;

public class ConnectFour {
	 
	private char[][] board = new char[6][7]; //6 rows; 7 columns
	private int turn;
		
	
	public ConnectFour() {
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = '*';
			}
		}
		
		turn = 1;
	}
	
	public boolean move(int player, int column) {
		char c = 'E';
		if(player == 1) {
			c = '1';
		}
		else if(player == 2) {
			c = '2';
		}
		
		if(turn == player) {
			for(int i = 5; i >= 0; i--) {
				if(board[i][column] == '*') {
					board[i][column] = c;
					
					if(turn == 1) {
						turn = 2;
					}
					else if(turn == 2) {
						turn = 1;
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int gameOver() {
		char c;
		
		// check horizontally
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j] != '*') {
					c = board[i][j];
					int count = 0;
					for(int k = j; k < j+4; k++) {
						if(board[i][k] == c) {
							count++;
						}
					}
					if(count == 4) {
						return 1;
					}
				}
			}
		}
		
		// check vertical
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[j][i] != '*') {
					c = board[j][i];
					int count = 0;
					for(int k = j; k < j+4; k++) {
						if(board[k][i] == c) {
							count++;
						}
					}
					if(count == 4) {
						return 1;
					}
				}
			}
		}
		
		// check 1 diagonal
		for(int j = 0; j < 3; j++) {
			for(int k = 0; k < 4; k++) {
				if(board[j][k] != '*') {
					c= board[j][k];
					int count = 0;
					
					for(int i = 0; i < 4; i++) {
						if(board[j+i][k+i] == c) {
							count++;
						}
					}
					
					if(count == 4) {
						return 1;
					}
				}
			}
		}
		
		// check other diagonal
		for(int j = 0; j < 3; j++) {
			for(int k = 0; k < 4; k++) {
				if(board[j+3][k] != '*') {
					c= board[j+3][k];
					int count = 0;
					
					for(int i = 0; i < 4; i++) {
						if(board[j+3-i][k+i] == c) {
							count++;
						}
					}
					
					if(count == 4) {
						return 1;
					}
				}
			}
		}
		
		/*
		if(board[2][0] == board[3][1] && board[4][2] == board[5][3] && board[3][1] == board[4][2] && board[2][0] != '*' ||
			board[1][0] == board[2][1] && board[3][2] == board[4][3] && board[2][1] == board[3][2] && board[1][0] != '*' ||
			board[2][1] == board[3][2] && board[4][3] == board[5][4] && board[3][2] == board[4][3] && board[2][1] != '*' ||
			board[0][0] == board[1][1] && board[2][2] == board[3][3] && board[1][1] == board[2][2] && board[0][0] != '*' ||
			board[1][1] == board[2][2] && board[3][3] == board[4][4] && board[2][2] == board[3][3] && board[1][1] != '*' ||
			board[2][2] == board[3][3] && board[4][4] == board[5][5] && board[3][3] == board[4][4] && board[2][2] != '*' 
			// hardcoding diagonals is STUPID!!	
				) {
			return 1;
		}
		*/
		
		//tests for open spots left
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '*') {
					return 0;
				}
			}
		}
			
		//tie
		return 2;
	}
	
	public int whoWon() {
		if(turn == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public String getBoardSpot(int row, int col) {
		return board[row][col] + "";
	}
	
	public String getBoardStr() {
		String boardStr = "";
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				boardStr += board[i][j];
				boardStr += " ";
			}
			boardStr += "\n";
		}
		
		return boardStr;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void setBoard(char[][] testBoard) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = testBoard[i][j];
			}
		}
	}
	
	public void setSpot(int row, int col) {
		board[row][col] = 'T';
	}
}
