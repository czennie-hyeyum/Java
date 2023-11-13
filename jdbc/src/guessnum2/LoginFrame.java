package guessnum2;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private UserDao userDao = UserDao.getInstance();
	
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
		setLayout(new GridLayout(3, 2, 10, 10));
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
		
        // 로그인 버튼
        if (obj == btnLogin) {
            String userId = tfId.getText();
            String userPw = new String(tfPw.getPassword());
            LoginDto loginDto = new LoginDto(userId, userPw);
            UserVo userVo = userDao.login(loginDto);
            if (userId.equals("") || userId.trim().equals("") || userPw.equals("") || userPw.trim().equals("")) {
                JOptionPane.showMessageDialog(LoginFrame.this, "아이디/비밀번호를 입력해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            } else {
                if (userVo == null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "로그인 실패", "에러", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "로그인 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
                    new GuessNumFrame(userVo);
                    this.dispose();
                }
            }

            // 사용자 등록 버튼
        } else if (obj == btnAddUser) {
            reaisterDialog.setReaisterDialog("사용자 등록");
            reaisterDialog.setVisible(true);
        }
	
	}
	
	class ReaisterDialog extends JDialog implements ActionListener {
		JTextField tfuserId = new JTextField();
		JPasswordField tfuserPw = new JPasswordField();
		JPasswordField tfuserCheckPw = new JPasswordField();
		JTextField tfuserName = new JTextField();
		JTextField tfuserEmail = new JTextField();
		String[] texts = {"아이디", "패스워드", "패스워드 확인", "이름", "이메일"};
		JTextField[] textFields = {tfuserId, tfuserPw, tfuserCheckPw, tfuserName, tfuserEmail};
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
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String title = getTitle();
			
			if (obj == btnFinish && title.equals("사용자 등록")) {
					UserVo userVo = new UserVo(tfuserId.getText(), 
												new String(tfuserPw.getPassword()), 
												tfuserName.getText(),
												tfuserEmail.getText());
					boolean result = userDao.addUser(userVo);
	                System.out.println("add result: "+ result);
	                
	                if (result) {
	                    JOptionPane.showMessageDialog(LoginFrame.this, "사용자 등록 완료", "완료", JOptionPane.INFORMATION_MESSAGE);
	                    
	                } else {
	                    JOptionPane.showMessageDialog(LoginFrame.this, "사용자 등록 실패", "에러", JOptionPane.ERROR_MESSAGE);
	                }
				
			} else if (obj == btnCancel) {
				this.setVisible(false);
			}
			
		}
		
	}

}