package ex01;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JButtonEx extends JFrame {
	private Container con = getContentPane();
	private ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
	private ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
	private ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
	private JButton button = new JButton("call~~", normalIcon);
	
	public JButtonEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("버튼 예제");
		setSize(500, 500);
		button.setPressedIcon(pressedIcon);
		button.setRolloverIcon(rolloverIcon);
		con.add(button);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new JButtonEx();
	}

}
