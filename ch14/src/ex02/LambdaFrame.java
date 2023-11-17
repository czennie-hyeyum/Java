package ex02;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LambdaFrame extends JFrame {
	Container con = getContentPane();
	JButton button = new JButton("버튼");
	
	public LambdaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("람다식 리스너");
		setSize(300, 300);
		con.add(button);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LambdaFrame();
	}

}
