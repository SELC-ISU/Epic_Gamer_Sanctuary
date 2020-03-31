package snakegame;
import java.util.Scanner;
import java.util.Random;

	public class SnakeGame
	{
		private int LengthofSnake;
		private int x_pos = 6;
		private int y_pos = 6; 
		private int Array[][] = new int [13][13];
		private boolean EdgeDetect;
		private int Apple;
		private boolean appleHere;
		private int Applex;
		private int Appley;
	
		
		public SnakeGame(int givenLength)
		{
			givenLength = LengthofSnake;
			Array[0][0] = 0;
		}
		
		public void getPosition()
		{
			System.out.println(Array[y_pos][x_pos]);
		}
		
		public void CreateGrid()
		{
			for(int i = 0; i <= 12; i++) {
				for(int j = 0; j <= 12; j++) {
					System.out.print(Array[i][j]);
				}
			   System.out.println();
			}
		}
		
		public void makeApple()
		{
			if(!appleHere)
			{
				Random r = new Random();
				
				Applex = r.nextInt(13);
				Appley = r.nextInt(13);
				
				Array[Appley][Applex] = 8;
				
				
				
				if(Array[Appley][Applex] == 8 && Array[y_pos][x_pos] == 1)
				{
					Array[Appley][Applex] = 0;
					LengthofSnake += 1;
				}
				
			}
			
		}
		
		public boolean appleExists()
		{
			for(int i = 0; i <= 12; i++) {
				for(int j = 0; j <= 12; j++) {
						if(Array[i][j] == 8)
						{
							appleHere = true;
						}
					}
				
				}
			
			return false;
		}
		
		public void DisplayCurrentGrid()
		{
			for(int i = 0; i <= 12; i++){
				for(int j = 0; j <= 12; j++){
					System.out.print(Array[i][j]);
				}
				System.out.println();
			}
		}
		
		public void moveRight(int six)
		{
			if(EdgeDetect)
			{
				System.out.println("Warning: edge of array cannot move this direction anymore");
			}
			else
			{
			Array[y_pos][x_pos] = 0;
			x_pos += 1;
			Array[y_pos][x_pos] = 1;
			}
					
		}
		   
		public void moveLeft(int four)
		{
			if(EdgeDetect)
			{
				System.out.println("Warning: edge of array cannot move this direction anymore");
			}
			else
			{
			Array[y_pos][x_pos] = 0;
			x_pos -= 1;
			Array[y_pos][x_pos] = 1;
			}
		}
		
		public void moveUp(int eight)
		{
			if(EdgeDetect)
			{
				System.out.println("Warning: edge of array cannot move this direction anymore");
			}
			else
			{
			Array[y_pos][x_pos] = 0;
			y_pos += 1;
			Array[y_pos][x_pos] = 1;
			}
		}
		
		public void moveDown(int two)
		{
			if(EdgeDetect)
			{
				System.out.println("Warning: edge of array cannot move this direction anymore");
			}
			else
			{
			Array[y_pos][x_pos] = 0;
			y_pos -= 1;
			Array[y_pos][x_pos] = 1;
			}
		}
		
		public int getLength()
		{
			return LengthofSnake;
		}
		
		public void getxpos()
		{
			System.out.println(Array[y_pos][x_pos]);
		}
		
		public int getypos()
		{
			return y_pos;
		}
		
		public void setEdgeDetect()
		{
			if(x_pos == 0 || x_pos == 12 || y_pos == 0 || y_pos == 12)
			{
				EdgeDetect = true;
			}
			else
			{
				EdgeDetect = false;
			}
		}
		
		public void testArrows()
		{
			System.out.println("Type in a directional arrow");
			Scanner arrow = new Scanner(System.in);
			
		}
		
		public void moveDirection()
		{
			
			do
			{
			appleExists();
			makeApple();
			DisplayCurrentGrid();
			System.out.println("What Direction would you like to move?");
			System.out.println("Eight is up, four is left, two is down, and six is right.");
			Scanner sc = new Scanner(System.in);
			int Direction = sc.nextInt();
				if(!(x_pos == 0 || x_pos == 12 || y_pos == 0 || y_pos == 12))
				{
					if(Direction == 8)
					{
					Array[y_pos][x_pos] = 0;
					y_pos -= 1;
					Array[y_pos][x_pos] = 1;
				}
					else if(Direction == 4)
					{
						Array[y_pos][x_pos] = 0;
						x_pos -= 1;
						Array[y_pos][x_pos] = 1;
					}
					else if(Direction == 2)
					{
						Array[y_pos][x_pos] = 0;
						y_pos += 1;
						Array[y_pos][x_pos] = 1;
					}
					else if(Direction == 6)
					{
						Array[y_pos][x_pos] = 0;
						x_pos += 1;
						Array[y_pos][x_pos] = 1;
					}
				
		 }
				if(Array[Appley][Applex] == 8 && Array[y_pos][x_pos] == 1)
				{
					if(Direction == 8)
					{
						Array[y_pos + 1][x_pos] = 1;
					}
					else if(Direction == 2)
					{
						Array[y_pos - 1][x_pos] = 1;
					}
					else if(Direction == 4)
					{
						Array[y_pos][x_pos + 1] = 1;
					}
					else if(Direction == 6)
					{
						Array[y_pos][x_pos - 1] = 1;
					}
					makeApple();
				}
		}while(!EdgeDetect);
	}
		
} 
				
		
	
