package ex03;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {
	private Container con = getContentPane();
	
	public GridLayoutEx() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("그리드 레이아웃 예제");
		this.setSize(500, 200);
		this.setUI();
		this.setVisible(true);
	}
	
	private void setUI() {
		con.setLayout(new GridLayout(2, 5, 5, 10));
		for(int i = 1; i <= 10; i++) {
			con.add(new JButton(String.valueOf(i)));
		}
	}
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
