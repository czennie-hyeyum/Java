package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IndepClassListener extends JFrame {
	private Container con = getContentPane();
	private JButton btnAction = new JButton("Action");
	private MyActionListener lis = new MyActionListener();

	public IndepClassListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("독립된 클래스로 리스너 만들기");
		setSize(500, 500);
		con.setLayout(new FlowLayout());
		con.add(btnAction);
		btnAction.addActionListener(lis);
		
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		new IndepClassListener();
	}

} // class

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// Action <-> 액션
		// 외부 클래스의 멤버(필드)에게 바로 접근이 안 되니 다운 캐스팅한다.
		Object obj = e.getSource();
		
		JButton theButton = (JButton)obj;
		String text = theButton.getText(); // 글자를 얻어낸다.
		if(text.equals("Action")) {
			theButton.setText("액션");
		} else {
			theButton.setText("Action");
		}
	}
	
}
