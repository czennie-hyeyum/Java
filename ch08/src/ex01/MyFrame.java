package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
		Container c = getContentPane();
		private JButton button1 = new JButton("클릭");

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("첫번째 프레임");
		setSize(300, 300);
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 100));
		c.setBackground(Color.ORANGE);
		c.add(button1);
		c.add(new JButton("취소"));
		c.add(new JButton("닫기"));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
