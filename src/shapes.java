import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class shapes {
	
	public int x;
	public int y;
	public boolean moving;
	public Rectangle rect1;
	public Rectangle rect2;
	public Rectangle rect3;
	public Rectangle rect4;
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	public abstract void move_left();
	
	public abstract void move_right();
	
	public abstract void rotate();

	public void stopMoving() {
		moving = false;
	}
}
