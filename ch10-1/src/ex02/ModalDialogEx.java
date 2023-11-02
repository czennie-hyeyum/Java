package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ModalDialogEx extends JFrame {
	Container con = getContentPane();
	JButton btnClick = new JButton("Click");
	MyDialog dialog = new MyDialog(this, "모달 다이얼로그", true);
	
	public ModalDialogEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("모달 다이얼로그 예제");
		setSize(500, 500);
		btnClick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				System.out.println("다이얼로그 열림");
			}
			
		});
		
		con.add(btnClick);
		setVisible(true);
		
	}
	
	public class MyDialog extends JDialog {
		JTextField tfName = new JTextField(10);
		JButton btnOk = new JButton("Ok");
		
		public MyDialog(JFrame frame, String title, boolean isModal) {
			super(frame, title, isModal);
			setLayout(new FlowLayout());
			setSize(200, 100);
			add(tfName);
			add(btnOk);
			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name = tfName.getText();
					btnClick.setText(name);
					MyDialog.this.setVisible(false);
				}
				
			});
		}
	}

	public static void main(String[] args) {
		new ModalDialogEx();
	}

}
