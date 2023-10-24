package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		con.setLayout(new FlowLayout());
		con.add(button);
		con.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new ListenerFrameEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton theButton = (JButton)obj;
		String text = theButton.getText();
		
		if(obj == button) {
			if(text.equals("Click")) {
				button.setText("클릭");
			} else if(text.equals("클릭")) {
				button.setText("Click");
			}
		}
	}

}
