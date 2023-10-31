package ex06;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VibratingFrame extends JFrame implements Runnable {
	private Container con = getContentPane();
	private Thread th = new Thread(this);
	private boolean isRun = true;
	
	public VibratingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("진동하는 프레임");
		setSize(500, 500);
		setLocation(700, 300);
		setVisible(true);
		con.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				th.interrupt();
				stopVibrating();
			}
		});
		
		th.start();
		
	}

	public static void main(String[] args) {
		new VibratingFrame();
	}
	
	public void stopVibrating() {
		isRun = false;
	}
	

	@Override
	public void run() {
		int MAX = 11;
		
		while (isRun) {
			int randomX = (int)(Math.random() * MAX) - 5;
			int randomY = (int)(Math.random() * MAX) - 5;
			int frameX = getX();
			int frameY = getY();
			
			setLocation(frameX + randomX, frameY + randomY);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				return;
			}
			
			
		}
	}

}
