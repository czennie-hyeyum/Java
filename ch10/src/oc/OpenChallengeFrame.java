package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengeFrame extends JFrame {
	Container con = getContentPane();
	int index = 0;
	JLabel lblImage = new JLabel(new ImageIcon("images/image0.jpg"));
	ImageIcon[] iconImages = { new ImageIcon("images/image0.jpg"),
							   new ImageIcon("images/image1.jpg"),
							   new ImageIcon("images/image2.jpg"),
							   new ImageIcon("images/image3.jpg")
							 };
	MenuPanel pnlMenu = new MenuPanel();
	
	
	public OpenChallengeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("간단 이미지 뷰어");
		setSize(400, 500);
		setUI();
		setVisible(true);
	}
	
	private void setUI() {
		con.add(lblImage, BorderLayout.CENTER);
		con.add(pnlMenu, BorderLayout.SOUTH);
	}
	
	public class MenuPanel extends JPanel implements ActionListener {
		private JButton btnLeft = new JButton(new ImageIcon("images/left.png"));
		private JButton btnRight = new JButton(new ImageIcon("images/right.png"));
		
		public MenuPanel() {
			add(btnLeft);
			add(btnRight);
			setBackground(Color.DARK_GRAY);
			btnLeft.addActionListener(this);
			btnRight.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnLeft) {
				index--;
				if(index > 0) {
					
				}
			} else if(obj == btnRight) {
				index++;
				if(index < 0) {
					
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		new OpenChallengeFrame();
	}

}
