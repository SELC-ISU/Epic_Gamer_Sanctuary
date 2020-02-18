package snakegame;

	public class SnakeGame
	{
		private int LengthofSnake;
		private int x_pos = 0;
		private int y_pos = 0; 
		private int Array[][] = new int [11][11];
		
		public SnakeGame(int givenLength)
		{
			givenLength = LengthofSnake;
			Array[0][0] = 1;
		}
		
		public int getPosition()
		{
			return Array[y_pos][x_pos];
		}
		
		public void CreateGrid()
		{
			for(int i = 0; i <= 10; i++)
				for(int j = 0; j <= 10; j++);
					System.out.println(Array);    
		}
		
		public void moveRight(int One)
		{
			Array[y_pos][x_pos] = 0;
			x_pos += 1;
			Array[y_pos][x_pos] = 1;
			
					
		}
		   
		public void moveLeft(int Three)
		{
			Array[y_pos][x_pos] = 0;
			x_pos -= 1;
			Array[y_pos][x_pos] = 1;
		}
		
		public void moveUp(int Two)
		{
			Array[y_pos][x_pos] = 0;
			y_pos += 1;
			Array[y_pos][x_pos] = 1;
		}
		
		public void moveDown(int Four)
		{
			Array[y_pos][x_pos] = 0;
			y_pos -= 1;
			Array[y_pos][x_pos] = 1;
		}
		
		public int getLength()
		{
			return LengthofSnake;
		}
		
		public int getxpos()
		{
			return x_pos;
		}
		
		public int getypos()
		{
			return y_pos;
		}
		
	}
