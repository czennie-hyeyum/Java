package ex04;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx2 extends JFrame {
	private Container con = getContentPane();
	private JLabel label = new JLabel("Hello");
	private static final int MOVE_UNIT = 10;
	
	public FlyingTextEx2() {
		super("키보드로 레이블 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		con.setLayout(null);
		label.setBounds(50, 50, 30, 15);
		con.add(label);
		con.addKeyListener(new MyKeyAdapter());
		
		con.setFocusCycleRoot(true);
		con.requestFocus();
		
	}
	
	class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			int x = label.getX();
			int y = label.getY();
			int maxX = con.getWidth() - label.getWidth();
			int maxY = con.getHeight() - label.getHeight();
			
				
			switch(keyCode) {
			case KeyEvent.VK_UP:
				y -= MOVE_UNIT;
				if(y < 0) {
					y = 0;
				}
				break;
				
			case KeyEvent.VK_DOWN:
				y += MOVE_UNIT;
				if(y > maxY) {
					y = maxY;
				}
				break;
				
			case KeyEvent.VK_LEFT:
				x -= MOVE_UNIT;
				if(x < 0) {
					x = 0;
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				x += MOVE_UNIT;
				if(x > maxX) {
					x = maxX;
				}
				break;
			}
			
			label.setLocation(x, y);
			
		}
	}
	
	public static void main(String[] args) {
		new FlyingTextEx2();
	}

}
