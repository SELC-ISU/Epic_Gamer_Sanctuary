package brickBreaker;

import java.awt.*;

public class Item extends Structure implements Constants{
	private int type;
	
	public Item(int x, int y, int width, int height, Color color, int type) {
		super(x, y, width, height, color);
		setType(type);
	}
	
	public void draw(Graphics g) {
		if(type == 3) {
			return;
		}
		g.setColor(color);
		g.fillRect(x,  y,  width, height);
	}
	
	public void drop() {
		y += 1;
	}
	
	public void resizePaddle(Paddle p) {
		if(getType() == 1 && p.getWidth() < PADDLE_MAX) {
			p.setWidth(p.getWidth() + 15);
		}
		else if(getType() == 2 && p.getWidth() > PADDLE_MIN) {
			p.setWidth(p.getWidth() - 15);
		}
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
}
