import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.Timer;

public class canvas extends JComponent {
	
	ArrayList<shapes> shapes = new ArrayList<>();
	ArrayList<Rectangle> filled = new ArrayList<>(); // keeps track of the squares that have are filled
	ArrayList<Rectangle> remove = new ArrayList<>(); // stores the rectangles that have to be removed at the end of the iteration
	
	shapes falling; // this is the shape thats moving
	boolean gameOver;
	Timer timer; // for having the shapes fall
	Timer timer2; // this is for moving the shapes left/right
	int num = 0;
	boolean clear; // for clearing the rows
	
	public canvas() {
	        
		timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num % 12 == 0) {
					Random rand = new Random();
					int numb = rand.nextInt(7);
					if (numb == 0) {
						falling = new shape1();
						shapes.add(falling);
					}
					else if (numb == 1) {
						falling = new shape2();
						shapes.add(falling);
					}
					else if (numb == 2) {
						falling = new shape3();
						shapes.add(falling);
					}
					else if (numb == 3) {
						falling = new shape4();
						shapes.add(falling);
					}
					else if (numb == 4) {
						falling = new shape5();
						shapes.add(falling);
					}
					else if (numb == 5) {
						falling = new shape6();
						shapes.add(falling);
					}
					else if (numb == 6) {
						falling = new shape7();
						shapes.add(falling);
					}
				}
				for (shapes i: shapes) {
					i.update();
				}
				repaint();
				num += 1;
				// so the shape that gets moved is always gonna be the last shape in the array
				for (Rectangle i: filled) {
					if (filled != null && ((falling.rect1.y == i.y - 50 && falling.rect1.x == i.x) || (falling.rect2.y == i.y - 50 && falling.rect2.x == i.x) 
							|| (falling.rect3.y == i.y - 50 && falling.rect3.x == i.x) || (falling.rect4.y == i.y - 50 && falling.rect4.x == i.x))) {
						falling.stopMoving();
					}
				}
				if (falling.moving == false || falling.rect1.y > 550 || falling.rect2.y > 550 || 
						falling.rect3.y > 550 || falling.rect4.y > 550) {
					filled.add(falling.rect1);
					filled.add(falling.rect2);
					filled.add(falling.rect3);
					filled.add(falling.rect4);
				}
				System.out.println(filled);
				for (int i = 0; i <= 450; i += 50) {
					if (!filled.contains(new Rectangle(i, 600, 50, 50))) {
						clear = false;
						break;
					}
					else {
						clear = true;
					}
				}
				if (clear == true) {
					/*for (Rectangle x: filled) {
						for (int v = 0; v < 500; v += 50) {
							if (x.equals(new Rectangle(v, 600, 50, 50))) {
								remove.add(x);
								System.out.println("Remove: " + remove);
							}
						}
					}*/
					clear_row(600);
				}
				/*for (int i = 0; i <= 450; i += 50) {
					if (!filled.contains(new Rectangle(i, 550, 50, 50))) {
						clear = false;
						break;
					}
					else {
						clear = true;
					}
				}
				if (clear == true) {
					clear_row(550);
				}*/ // this part kinda works but it shifts everything down and doesnt remove the full row so
				// the bottom row then becomes full and then it clears too
				
			}
			
		});
		timer.start();
	}

	public void paintComponent(Graphics g) {
		for (shapes i: shapes) {
			i.draw(g);
		}
	}
	
	public void clear_row(int row) {
		for (Rectangle i: filled) {
			if (i.y <= row) {
				i.y += 50;
				repaint();
			}
		}
	}
}
