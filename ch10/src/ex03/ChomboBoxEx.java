package ex03;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChomboBoxEx extends JFrame {
	private Container con = getContentPane();
	
	public ChomboBoxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("콤보박스 예제");
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChomboBoxEx();
	}
	
}
