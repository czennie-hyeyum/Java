package guessnum2;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {
	Container con = getContentPane();
	JLabel lblId = new JLabel("아이디");
	JLabel lblPw = new JLabel("패스워드");
	JTextField tfId = new JTextField();
	JPasswordField tfPw = new JPasswordField();
	JButton btnLogin = new JButton("로그인");
	JButton btnAddUser = new JButton("사용자 등록");
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(300, 200);
		setUI();
		setVisible(true);
	}
	
	public void setUI() {
		setIdOrPw();
		setLayout(new GridLayout(3, 2, 10, 20));
	}
	
	public void setIdOrPw() {
		con.add(lblId);
		con.add(tfId);
		con.add(lblPw);
		con.add(tfPw);
		con.add(btnLogin);
		con.add(btnAddUser);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		
	}

}
