import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class shape4 extends shapes {
	
	public shape4() {
		y = -50;
		x = 200;
		moving = true;
		rect1 = new Rectangle(x, y, 50, 50);
		rect2 = new Rectangle(x + 50, y, 50, 50);
		rect3 = new Rectangle(x + 50, y + 50, 50, 50);
		rect4 = new Rectangle(x, y + 50, 50, 50);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(243, 243, 101));
		g.fillRect(rect1.x, rect1.y, rect1.width, rect1.height);
		g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
		g.fillRect(rect3.x, rect3.y, rect3.width, rect3.height);
		g.fillRect(rect4.x, rect4.y, rect4.width, rect4.height);
		g.setColor(Color.BLACK);
		g.drawRect(rect1.x, rect1.y, rect1.width, rect1.height);
		g.drawRect(rect2.x, rect2.y, rect2.width, rect2.height);
		g.drawRect(rect3.x, rect3.y, rect3.width, rect3.height);
		g.drawRect(rect4.x, rect4.y, rect4.width, rect4.height);
	}

	@Override
	public void update() {
		if (rect1.y >= 550 /* or hits another brick*/) {
			moving = false;
		}
		if (moving == true) {
			rect1.y += 50;
			rect2.y += 50;
			rect3.y += 50;
			rect4.y += 50;
		}
	}

	@Override
	public void move_left() {
		if (moving == true && rect1.x > 0) {
			rect1.x -= 50;
			rect2.x -= 50;
			rect3.x -= 50;
			rect4.x -= 50;
		}
	}
	
	public void move_right() {
		if (moving == true && rect1.x < 400) {
			rect1.x += 50;
			rect2.x += 50;
			rect3.x += 50;
			rect4.x += 50;
		}
	}

	@Override
	public void rotate() {
	
	}

}
