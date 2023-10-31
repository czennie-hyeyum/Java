package ex02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseMotionListenerEx extends JFrame {
	Container con = getContentPane();
	JLabel lblHello = new JLabel("Hello");
	MyMouseMotionListener lis = new MyMouseMotionListener();
	
	public MouseMotionListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 리스너 예제");
		setSize(500, 500);
		setVisible(true);
		setLayout(null);
		lblHello.setBounds(10, 10, 100, 30);
		con.add(lblHello);
		con.addMouseMotionListener(lis);
	}
	
	class MyMouseMotionListener implements MouseMotionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("mouseDragged");
			int x = e.getX();
			int y = e.getY();
			lblHello.setLocation(x, y);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("mouseMoved");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}

	public static void main(String[] args) {
		new MouseMotionListenerEx();
	}

}
