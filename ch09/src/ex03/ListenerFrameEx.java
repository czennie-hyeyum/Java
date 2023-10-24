package ex03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ListenerFrameEx extends JFrame 
		implements ActionListener {
	Container con = getContentPane();
	JButton button = new JButton("Click");
	
	public ListenerFrameEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("프레임 리스너 예제");
		setSize(500, 500);
		setVisible(true);
		con.add(button);
		button.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new ListenerFrameEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭");
	}

}
