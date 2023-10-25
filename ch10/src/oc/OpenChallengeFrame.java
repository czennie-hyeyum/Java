package oc;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class OpenChallengeFrame extends JFrame {
	Container con = getContentPane();
	
	public OpenChallengeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("간단 이미지 뷰어");
		con.setLayout(new BorderLayout());
		JLabel lblCenter = new JLabel();
		JButton btnLeft = new JButton();
		JButton btnRight = new JButton();
		
		setSize(400, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OpenChallengeFrame();
	}

}
