package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {
	Container container = getContentPane(); 
	String[] texts = {"add", "sub", "mul", "div", "Calculate"};
	String[] positions = {
		BorderLayout.EAST,
		BorderLayout.WEST,
		BorderLayout.SOUTH,
		BorderLayout.NORTH,
		BorderLayout.CENTER
	};
	
	
	public BorderLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		container.setLayout(new BorderLayout(20, 20));
		for(int i = 0; i < texts.length; i++) {
			container.add(new JButton(texts[i]), positions[i]);
		}
		container.setBackground(Color.DARK_GRAY);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}
