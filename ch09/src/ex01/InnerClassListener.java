package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InnerClassListener extends JFrame {
	private Container con = getContentPane();
	private JButton btnAction = new JButton("Action");
	private JButton btnJava = new JButton("Java");
	private YourActionListener lis = new YourActionListener();

	public InnerClassListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("내부 클래스로 리스너 만들기");
		setSize(500, 500);
		con.setLayout(new FlowLayout());
		con.add(btnAction);
		con.add(btnJava);
		btnAction.addActionListener(lis);
		btnJava.addActionListener(lis);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new InnerClassListener();
	}
	
	// 내부 클래스 - 멤버처럼 사용하고자 할 때
	// 다운캐스팅 할 필요 없이 외부 클래스의 멤버(필드, 메서드)에 바로 접근이 가능하다.
	class YourActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Action <-> 액션
			/*
			Object obj = e.getSource();
			JButton theButton = (JButton)obj;
			*/
			
			Object obj = e.getSource(); // 액션 이벤트가 발생한 객체
			JButton theButton = (JButton)obj;
			String text = theButton.getText();
			// 외부 클래스의 멤버(필드)에 접근 가능
			if (obj == btnAction) {
				if (text.equals("Action")) {
					btnAction.setText("액션");
				} else {
					btnAction.setText("Action");
				}
				
			} else if (obj == btnJava) {
				if (text.equals("Java")) {
					btnJava.setText("자바");
				} else {
					btnJava.setText("Java");
				}
			}
			
			
			// 외부 클래스의 멤버(필드)인 btnAction에 바로 접근
			/*
			String text = btnAction.getText(); // 글자를 얻어낸다.
			if(text.equals("Action")) {
				btnAction.setText("액션");
			} else {
				btnAction.setText("Action");
			}
			*/
		}
		
	}

} // class


