package snakegame;

public class SnakeGameTest {

	public static void main (String[] agrs)
	{
		SnakeGame s = new SnakeGame(5);
	
		
		s.setEdgeDetect();
		s.CreateGrid();
		s.moveDirection();
		
		
		
		/*
		s.setEdgeDetect();
		s.CreateGrid();
		s.makeApple();
		s.DisplayCurrentGrid();
		*/
	}
}
