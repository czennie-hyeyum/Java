package guessnum2;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {
	Container con = getContentPane();
	JTextField tfId = new JTextField();
	JPasswordField tfPw = new JPasswordField();
	JButton btnLogin = new JButton("로그인");
	JButton btnAddUser = new JButton("사용자 등록");
	private ReaisterDialog reaisterDialog = new ReaisterDialog(this, "입력/수정", true);
	private List<UserVo> userList;
	UserVo userVo = new UserVo();
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(300, 150);
		setLocationRelativeTo(null);
		setUI();
		setListener();
		setVisible(true);
	}
	
	private void setUI() {
		setIdOrPw();
		setUserList();
		setLayout(new GridLayout(3, 2, 10, 10));
	}
	
	private void setUserList() {
		userList = new ArrayList<>();
	}
	
	private void setIdOrPw() {
		con.add(new JLabel("아이디"));
		con.add(tfId);
		con.add(new JLabel("패스워드"));
		con.add(tfPw);
		con.add(btnLogin);
		con.add(btnAddUser);
	}
	
	private void setListener() {
		tfId.addActionListener(this);
		tfPw.addActionListener(this);
		btnLogin.addActionListener(this);
		btnAddUser.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnLogin) {
			String id = tfId.getText();
			String pw = new String(tfPw.getPassword());
			if (obj == tfId || obj == tfPw) {
			} if(id == null || id.trim().equals("")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "아이디를 입력해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
			} else if(pw == null || pw.trim().equals("")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "비밀번호를 입력해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj == btnAddUser) {
			reaisterDialog.setReaisterDialog("사용자 등록");
			reaisterDialog.setVisible(true);
		}
		
	}
	
	class ReaisterDialog extends JDialog implements ActionListener {
		JTextField tfReaisterId = new JTextField();
		JPasswordField tfReaisterPw = new JPasswordField();
		JPasswordField tfReaisterCheckPw = new JPasswordField();
		JTextField tfReaisterName = new JTextField();
		JTextField tfReaisterEmail = new JTextField();
		String[] texts = {"아이디", "패스워드", "패스워드 확인", "이름", "이메일"};
		JTextField[] textFields = {tfReaisterId, tfReaisterPw, tfReaisterCheckPw, tfReaisterName, tfReaisterEmail};
		JButton btnFinish = new JButton("완료");
		JButton btnCancel = new JButton("취소");
		
		public ReaisterDialog(JFrame owner, String title, boolean isModal) {
			super(owner, title, isModal);
			setSize(300, 300);
			setLocationRelativeTo(owner);
			setLayout(new GridLayout(6, 2, 10, 10));
			setUI();
			setListener();
		}
		
		private void setUI() {
			for(int i = 0; i < texts.length; i++) {
				add(new JLabel(texts[i]));
				add(textFields[i]);
			}
			add(btnFinish);
			add(btnCancel);
		}
		
		private void setListener() {
			btnFinish.addActionListener(this);
			btnCancel.addActionListener(this);
		}
		
		private void setReaisterDialog(String title) {
			setTitle(title);
			if (title.equals("사용자 등록")) {
				
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String title = getTitle();
			
			if (obj == btnFinish) {
				if(title.equals("사용자 등록")) {
					userVo.setUserId(tfReaisterId.getText());
					userVo.setUserPw(new String(tfReaisterPw.getPassword()));
					userVo.setUserCheckPw(new String(tfReaisterCheckPw.getPassword()));
					userVo.setUserName(tfReaisterName.getText());
					userVo.setUserEmail(tfReaisterEmail.getText());
					userList.add(userVo);
					
					for(UserVo user : userList) {
						System.out.println(user);
					}
					
				}
			} else if (obj == btnCancel) {
				this.setVisible(false);
			}
			this.setVisible(false);
		}
		
	}

}