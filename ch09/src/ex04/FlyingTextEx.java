package ex04;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx extends JFrame {
	private Container con = getContentPane();
	private JLabel label = new JLabel("Hello");
	private static final int MOVE_UNIT = 10;
	
	public FlyingTextEx() {
		super("키보드로 레이블 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		con.setLayout(null);
		label.setBounds(50, 50, 30, 15);
		label.setOpaque(true);
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
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				label.setLocation(x, y - MOVE_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				label.setLocation(x, y + MOVE_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				label.setLocation(x - MOVE_UNIT, y);
				break;
			case KeyEvent.VK_RIGHT:
				label.setLocation(x + MOVE_UNIT, y);
				break;

			}
		}
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
