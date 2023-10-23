package ex01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class OneToTenFrame extends JFrame {
	Container con = getContentPane();
	JButton[] buttons = new JButton[10];
	MyActionListener lis = new MyActionListener();
	
	public OneToTenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("One To Ten");
		con.setLayout(null);
		
		for(int i = 0; i <= 9; i++) {
			JButton button = new JButton(String.valueOf(i + 1));
			button.setSize(50, 50);
			int x = (int)(Math.random() * (484-50));
			int y = (int)(Math.random() * (461-50));
			button.setLocation(x, y);
			button.addActionListener(lis);
			con.add(button);
			buttons[i] = button;
		}
		
		setSize(500, 500);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new OneToTenFrame();
	}
	
	
	class MyActionListener implements ActionListener {
		int nextNumber = 1;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton theButton = (JButton)obj;
			String text = theButton.getText();
			
			if(text.equals(String.valueOf(nextNumber))) {
				theButton.setVisible(false);
				nextNumber++;
				if(nextNumber > 10) {
					restart();
				}
			}
		}

		private void restart() {
			for (int i = 0; i < buttons.length; i++) {
				int x = (int)(Math.random() * (484-50));
				int y = (int)(Math.random() * (461-50));
				buttons[i].setLocation(x, y);
				buttons[i].setVisible(true);
			}
			
			nextNumber = 1;
		}
		
	}

} // class
