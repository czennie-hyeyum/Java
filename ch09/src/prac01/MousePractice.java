package prac01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MousePractice extends JFrame {
	MymouseListener lis = new MymouseListener();
	Container con = getContentPane();
	JLabel lblLove = new JLabel("자기야");
	
	public MousePractice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 연습");
		setSize(300, 180);
		setVisible(true);
		con.setLayout(new FlowLayout());
		con.add(lblLove);
		lblLove.addMouseListener(lis);
		con.addMouseMotionListener(lis);
		lblLove.addMouseListener(lis);
		con.setBackground(Color.GREEN);
		
	}
	
	class MymouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			con.setBackground(Color.GREEN);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == lblLove) {
				lblLove.setText("사랑해");
			}
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblLove.setText("자기야");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			con.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}

	public static void main(String[] args) {
		new MousePractice();
	}

}
