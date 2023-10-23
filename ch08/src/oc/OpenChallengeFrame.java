package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengeFrame extends JFrame {
	Container con = getContentPane();
	
	public OpenChallengeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Open Challenge 8");
		setSize(500, 500);
		setUI();
		setVisible(true);
	}
	
	public void setUI() {
		setNorth();
		setCenter();
	}
	
	public void setNorth() {
		con.add(new NorthPanel(), BorderLayout.NORTH);
	}
	
	public void setCenter() {
		con.add(new CenterPanel(), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new OpenChallengeFrame();
	}

}

@SuppressWarnings("serial")
class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
	}
}

@SuppressWarnings("serial")
class CenterPanel extends JPanel {
	public CenterPanel() {
	
	}
}

