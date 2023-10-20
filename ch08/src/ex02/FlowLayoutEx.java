package ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FlowLayoutEx extends JFrame {
	Container container = getContentPane(); 
	String[] texts = {"add", "sub", "mul", "div", "Calculate"};
	
	
	public FlowLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		container.setBackground(Color.DARK_GRAY);
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		for(int i = 0; i < texts.length; i++) {
			container.add(new JButton(texts[i]));
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutEx();
	}

}
