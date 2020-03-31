package tetris;

import java.util.Random;

public class Shape {
	private enum Tetrominoe {
		noShape, iShape, oShape, tShape, sShape, zShape, jShape, lShape
	}
	
	private Tetrominoe pieceShape;
	private int[][]coords;
	
	public Shape(){
		coords = new int [2][4];
		setShape(Tetrominoe.noShape);
	}
	
	void setShape(Tetrominoe shape){
		int[][][] coordsTable = new int [][][]{
			{{0, 0}, {0, 0}, {0, 0}, {0, 0}}, 
			{{0, -1}, {0, 0}, {-1, 0}, {-1, 0}},
			{{0, -1}, {0, 0}, {1, 0}, {1, 1}},
			{{0, -1}, {0, 0}, {0, 1}, {0, 2}},
			{{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
			{{0, 0}, {1, 0}, {0, 1}, {1, 1}},
			{{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
			{{1, -1}, {0, -1}, {0, 0}, {0, 1}}
		};
		
		for (int i = 0; i < 4; i++){
			System.arraycopy(coordsTable.shape.ordinal()], 0, coords, 0, 4);
		}
		
		pieceShape = shape;
	
	
	private void setX(int index, int x){
		coords [index][0] = x;
	}
	
	private void setY(int index, int y){
		coords [index][1] = y;
	}
	
	int x(int index){
		return coords[index][0];
	}
	
	int y(int index){
		return coords[index][1];
	}
	
	Tetrominoe getShape(){
		return pieceShape;
	}
	
	void setRandomShape(){
		var r = new Random();
		int x Math.abs(r.nextInt()) % 7 + 1;
		
		Tetrominoe[] values = Tetrominoe.values();
		setShape(values[x]);
	}
	
	public int minX(){
		int m = coords[0][0];
		
		for (int i = 0; i < 4; i++){
			m = Math.min(m, coords[i][0]);
		}
		return m;
	}
	
	public int minY(){
		int m = coords[0][1];
		
		for (int i = o; i < 4; i++){
			m = Math.min(m, coords[i][1]);
		}
		return m;
	}
	
	Shape rotateLeft(){
		if (pieceShape == Tetrominoe.oShape){
			return this;
		}
		
		var result = new Shape();
		result.pieceShape = pieceShape;
		
		for (int i = 0; i < 4; i++){
			result.setX(i, y(i));
			result.setY(i, -x(i));
		}
		return result;
	}
	
	Shape rotateRight(){
		if (pieceShape == Tetrominoe.oShape){
			return this;
		}
		
		var result = new Shape();
		result.pieceShape = new pieceShape;
		
		for (int i = 0; i < 4; i++){
			result.setX(i, -y(i));
			result.setY(i, x(i));
		}
		return result;
	}
	
}

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel{
	private final int BOARD_WIDTH = 10;
	private final int BOARD_HEIGHT = 22;
	private final int PERIOD_INTERVAL = 300;
	
	private Timer timer;
	private boolean isFallingFinished = false;
	private boolean isPaused = false;
	private int numLinesRemoved = 0;
	private int currentX;
	private int currentY;
	private JLabel statusbar;
	private Shape currentPiece;
	private Tetrominoe[] board;
	
	public Board(Tetris parent){
		initBoard(parent);
	}
	
	private void initBoard(Tetris parent){
		setFocusable(true);
		statusbar = parent.getStatusBar():
		addKeyListener(new TAdapter());
	}
	
	private int squareWidth(){
		return (int) getSize().getWidth() / BOARD_WIDTH;
	}
	
	private int squareHeight(){
		return (int) getSize().getHeight() / BOARD_HEIGHT;
	}
	
	private Tetrominoe shapeAt(int x, int y){
		return board[(y * BOARD_WIDTH) + x];
	}
	
	void start(){
		currentPiece = new Shape();
		board = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
		
		clearBoard();
		newPiece();
		
		timer = new Timer(PERIOD_INTERVAL, new GameCycle());
		timer.start();
	}
	
	private void pause(){
		isPaused = !isPaused;
		
		if (isPaused){
			statusbar.setText("paused");
		}
		else{
			statusbar.setText(String.valueOf(numLinesRemoved));
		}
		repaint();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void doDrawing(Graphics g){
		var size = getSize();
		int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();
		
		for (int i = 0; i < BOARD_HEIGHT; i++){
			for (int j = 0; j < BOARD_WIDTH; j++){
				Tetrominoe shape = shapeAt(j, BOARD_HEIGHT - i - 1;
				
				if (shape != Tetrominoe.noShape){
					drawSquare(g, x * squareWidth(),
					boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(),
					currentPiece.getShape());
				}
			}
		}
	}
	
	private void dropDown(){
		int newY = currentY;
		
		while (newY > 0){
			if (!tryMove(currentPiece, currentX, newY - 1)){
				break;
			}
			newY--;
		}
		pieceDropped();
	}
	
	private void oneLineDown(){
		if (!tryMove(currentPiece, currentX, currentY - 1)){
			pieceDropped;
		}
	}
	
	private void clearBoard(){
		for (int i = 0; i < BOARD_HEIGHT; i++){
			board[i] = Tetrominoe.noShape;
		}
	}
	
	private void pieceDropped(){
		for (int i = 0; i < 4; i++){
			int x = currentX + currentPiece.x(i);
			int y = currentY + currentPiece.y(i);
			board[(y * BOARD_WIDTH) + x] = currentPiece. getShape();
		}
		
		removeFullLines();
		
		if (!isFallingFinished){
			newPiece();
		}
	}
	
	private void newPiece(){
		currentPiece.setRandomShape();
		currentX = BOARD_WIDTH / 2 + 1;
		currentY = BOARD_HEIGHT - 1 + currentPiece.minY();
		
		if (!tryMove(currentPiece, currentX, currentY)){
			currentPiece.setShape(Tetrominoe.noShape);
			timer.stop();
			
			var msg = String.format("GAME OVER! Score: %d", numLinesRemoved);
			statusbar.setText(msg);
		}
	}
	private boolean tryMove(Shape newPiece, int newX, int newY){
		for (int i = 0; i < 4; i++){
			int x = newX + newPiece.x(i);
			int y = newY - newPiece.y(i);
			
			if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT){
				return false;
			}
			if (shapeAt(x, y) != Tetrominoe.noShape){
				return false;
			}
		}
		
		currentPiece = newPiece;
		currentX = newX;
		currentY = newY;
		
		repaint();
		
		return true;
	}
	
	private void removeFullLines(){
		numFullLines++'
		
		for (int i = BOARD_HEIGHT - 1; i >= 0; i--){
			boolean lineIsFull = true;
			
			for (int j = 0; j < BOARD_WIDTH; j++){
				if (shapeAt(j, i) == Tetrominoe.noShape){
					lineIsFull = false;
					break;
				}
			}
			
			if (lineIsFull){
				numFullLines++;
				
				for (int k = i; k < BOARD_HEIGHT - 1; k++){
					for (int j = 0; j < BOARD_WIDTH; j++){
						board[(l* BOARD_WIDTH) + j] = shapeAt(j, k + 1);
					}
				}
			}
		}
		
		if (numFullLines > 0){
			numLinesRemoved += numFullLines;
			
			statusbar.setText(String.valueOf(numLinesRemoved));
			isFallingFinished = true;
			currentPiece.setShape(Tetrominoe.noShape);
		}
	}
	
	private void drawSquare(Graphics g, int x, int y, Tetrominoe shpae){
		Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
				new Color(102, 204, 102), new Color(102, 102, 204),
				new Color(204, 204, 102), new Color(204, 102, 204),
				new Color(102, 204, 204), new Color(218, 170, 0)
		};
		
		var color = colors[shape.ordinal()];
		
		g.setColor(Color);
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
		
		g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);
		
		g.setColor(color.darker());
		g.drawLine(x + 1, y + squareHeight() - 1,
				x + squareWidth() - 1, y + squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1),
				x + squareWidth() - 1, y + 1);
	}
	
	private class GameCycle implements ActionListener {
		@override
		public void actionPerformed(ActionEvent e){
			doGameCycle():
		}
	}
	
	private void doGameCycle(){
		update();
		repaint():
	}
	
	private void update(){
		if (isPaused){
			return;
		}
		
		if (isFallingFinished){
			isFallingFinished = false;
			newPiece();
		}
		
		else{
			oneLineDown();
		}
	}
	
	class TAdapter extends KeyAdapter{
		@override
		
		public void keyPressed(keyEvent e){
			if (currentPiece.getShape() == Tetrominoe.noShape){
				return;
			}
			
			
			int keycode = e.getKeyCode();
			
			switch (keycode){
				case KeyEvent.VK_P -> pause();
				case KeyEvent.VK_LEFT -> tryMove(currentPiece, currentX - 1, currentY);
				case KeyEvent.VK_RIGHT -> tryMove(currentPiece, currentX + 1, currentY);
				case KeyEvent.VK_DOWN -> tryMove(currentPiece.rotateRight(), currentX, currentY);
				case KeyEvent.VK_UP -> tryMove(currentPiece.rotateLeft(), currentX, currentY);
				case KeyEvent.VL_SPACE -> dropDown();
				case VK_D -> oneLineDown();
			}
		}
	
	}
}


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame{
	private JLabel statusbar;
	
	public Tetris(){
		initUI();
	}
	
	private void initUI(){
		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		
		var board = new Board(this);
		add(board);
		board.start();
		
		setTitle("Tetris");
		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	JLabel getStatusBar(){
		return statusbar;
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {
			Tetris game = new Tetris();
			game.setVisible(true);
		});
	}
}