import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class game extends JFrame implements KeyListener {
	
	canvas can;
	
	public game() {
		JFrame frame = new JFrame("TETRIS");
		frame.addKeyListener(this);
		can = new canvas();
		frame.add(can);
		frame.setSize(500, 675);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new game();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 39) {
			can.falling.move_right();
			repaint();
		}
		if (e.getKeyCode() == 37) {
			can.falling.move_left();
			repaint();
		}
		if (e.getKeyCode() == 38) {
			can.falling.rotate();
			repaint();
		}
		if (e.getKeyCode() == 40) {
			// down arrow key
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
