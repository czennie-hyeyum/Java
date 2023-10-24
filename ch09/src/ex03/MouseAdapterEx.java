package ex03;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MouseAdapterEx extends JFrame {
	Container con = getContentPane();
	
	public MouseAdapterEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 어댑터 예제");
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseAdapterEx();
	}

}
