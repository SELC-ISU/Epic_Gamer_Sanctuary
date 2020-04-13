package brickBreaker;

import javax.swing.*;
import java.awt.*;

public class BrickBreaker_GUI extends JFrame implements Constants{
	private static JFrame frame;
	private static Board board;
	private static Container pane;
	private static Dimension dim;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		frame = new JFrame("Brick Breaker");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		board = new Board(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		pane = frame.getContentPane();
		pane.add(board);
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		
		frame.setVisible(true);
	}
}
