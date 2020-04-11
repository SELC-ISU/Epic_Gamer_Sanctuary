package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import tetris.Tetris;

public class Tetris_GUI {

	private static int time = 1000;
	
	JFrame f;
	final Tetris game;
	
	public Tetris_GUI() {
		f = new JFrame("Tetris");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(12 * 26 + 10, 26 * 23 + 25);
		f.setVisible(true);
		
		game = new Tetris();
		game.init();
		f.add(game);
		
		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
					game.rotate(-1);
					break;
				case KeyEvent.VK_DOWN:
					game.rotate(+1);
					break;
				case KeyEvent.VK_LEFT:
					game.move(-1);
					break;
				case KeyEvent.VK_RIGHT:
					game.move(+1);
					break;
				case KeyEvent.VK_SPACE:
					game.dropDown();
					break;
			}
		}
			
		public void keyReleased(KeyEvent e) {
		}
	});
	
	new Thread() {
		@Override public void run() {
			while (true) {
				try {
					Thread.sleep(time);
					game.dropDown();
				} catch(InterruptedException e) {}
			}
		}
	}.start();
	}
}
