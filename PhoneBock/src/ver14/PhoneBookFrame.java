package ver14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame implements ActionListener {
	private static final String DELIM = " / ";
	private PhoneBook book = PhoneBook.getInstance();
	private Container con = getContentPane();
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
	
	// North
	JMenuBar menuBar = new JMenuBar();
	JMenu mnuFile = new JMenu("파일");
	JMenuItem miLoad = new JMenuItem("불러오기"); 
	JMenuItem miInput = new JMenuItem("입력");
	JMenuItem miGetAll = new JMenuItem("전체 조회");
	JMenuItem miUpdate = new JMenuItem("수정");
	JMenuItem miDelete = new JMenuItem("삭제");
	JMenuItem miExit = new JMenuItem("종료");
	JTextField tfSearch = new JTextField(10);
	JButton btnSearch = new JButton("찾기");
	
	// Center
		JTextArea taMessage = new JTextArea();
		
	// South
	JButton btnInput = new JButton("입력");
	JButton btnGetAll = new JButton("전체조회");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnExit = new JButton("종료");
	
	private InputDialog inputDialog = new InputDialog(this, "입력/수정", true);
	
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번호부 ver.14");
		setSize(500, 500);
		setLocationRelativeTo(null);
		fileMenu();
		setUI();
		setListener();
		setVisible(true);
	}
	
	
	private void fileMenu() {
		menuBar.add(mnuFile);
		mnuFile.add(miLoad);
		mnuFile.add(miInput);
		mnuFile.add(miGetAll);
		mnuFile.add(miUpdate);
		mnuFile.add(miDelete);
		mnuFile.addSeparator();
		mnuFile.add(miExit);
		
		setJMenuBar(menuBar);
		
	}
	
	private void setListener() {
		tfSearch.addActionListener(this);
		btnSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnGetAll.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		miInput.addActionListener(this);
		miGetAll.addActionListener(this);
		miUpdate.addActionListener(this);
		miDelete.addActionListener(this);
		miExit.addActionListener(this);
		miLoad.addActionListener(this);
		
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}


	private void setNorth() {
		JPanel pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(1, 1));
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(new JLabel("검색:"));
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		pnlInput.add(pnlSearch);
		con.add(pnlInput, BorderLayout.NORTH);
		
	}
	
	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(1, 1));
		JPanel pnlButton = new JPanel();
		pnlButton.add(btnInput);
		pnlButton.add(btnGetAll);
		pnlButton.add(btnUpdate);
		pnlButton.add(btnDelete);
		pnlButton.add(btnExit);
		pnlSouth.add(pnlButton);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void setCenter() {
		taMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new PhoneBookFrame();
	}
	
	private void printData(PhoneInfo info) {
		taMessage.setText("");
		
		String name = info.getName();
		String phoneNumber = info.getPhoneNumber();
		String birthDay = info.getBirthDay();
		String schoolOrCompanyName = "";
		if (info instanceof PhoneInfoSchool) {
			schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
		} else {
			schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
		}
		taMessage.append(name + DELIM);
		taMessage.append(phoneNumber + DELIM);
		taMessage.append(birthDay + DELIM);
		taMessage.append(schoolOrCompanyName + "\n");
		
	}
	
	private void printData(Vector<PhoneInfo> vector) {
		taMessage.setText("");
		for (PhoneInfo info : vector) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompanyName = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
			} else {
				schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
			}
			taMessage.append(name + DELIM);
			taMessage.append(phoneNumber + DELIM);
			taMessage.append(birthDay + DELIM);
			taMessage.append(schoolOrCompanyName + "\n");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		chooser.setFileFilter(filter);
		
		
		// ----------- 입력 -----------	
		if (obj == btnInput || obj == miInput) {
			inputDialog.resetFields();
			inputDialog.setInputOrUpdate("입력");
			inputDialog.setVisible(true);
			
		// ----------- 불러오기 -----------	
		} else if (obj == miLoad) {
			chooser.setFileFilter(filter);
				
			int result = chooser.showOpenDialog(PhoneBookFrame.this);
			
			if (result == JFileChooser.APPROVE_OPTION) {
				String fileName = chooser.getSelectedFile().getAbsolutePath();
				try {
					book.readData(fileName);
					JOptionPane.showMessageDialog(PhoneBookFrame.this, "데이터를 성공적으로 불러왔습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(PhoneBookFrame.this, "데이터 불러오기에 실패했습니다.", "에러", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		// ----------- 검색 -----------	
		} else if (obj == tfSearch || obj == btnSearch) {
			String name = tfSearch.getText();
			PhoneInfo info = book.searchByName(name);
			if (info == null) {
				JOptionPane.showMessageDialog(PhoneBookFrame.this, name + "님의 정보가 없습니다.", "알림", JOptionPane.OK_CANCEL_OPTION);
			} else {
				printData(info);
			}
			
		// ----------- 없을 경우 -----------	
		} else if (obj == btnGetAll || obj == miGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
			if (vector == null || vector.size() == 0) {
				JOptionPane.showMessageDialog(PhoneBookFrame.this, "데이터가 없습니다.", "알림", JOptionPane.ERROR_MESSAGE);
			} else {
				printData(vector);
			}
			
		// ----------- 수정 -----------	
		} else if (obj == btnUpdate || obj == miUpdate) {
			String name = JOptionPane.showInputDialog(PhoneBookFrame.this, "이름을 입력하세요", "입력", JOptionPane.OK_CANCEL_OPTION);
			if (name != null && !name.equals("")) {
				inputDialog.setInputOrUpdate("수정");
				PhoneInfo info = book.searchByName(name);
				if (info == null) {
					JOptionPane.showMessageDialog(PhoneBookFrame.this, name + "님을 찾을 수 없습니다.");
					return;
				}
				
				inputDialog.setInfo(info);
				inputDialog.setVisible(true);
				
			} 
			
		// 	----------- 삭제 -----------
		} else if (obj == btnDelete || obj == miDelete) {
			String name = JOptionPane.showInputDialog(PhoneBookFrame.this, "이름을 입력하세요", "입력", JOptionPane.OK_CANCEL_OPTION);
			
			if (name != null) {
			PhoneInfo info = book.searchByName(name);
			
			if (info != null) {
			    int delete = JOptionPane.showConfirmDialog(PhoneBookFrame.this, name + "님의 정보를 정말로 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
			    
			    if (delete == JOptionPane.YES_OPTION) {
			    	boolean result = book.delete(name);
		            if (result) {
		                JOptionPane.showMessageDialog(PhoneBookFrame.this, name + "님의 정보가 삭제되었습니다.", "알림", JOptionPane.OK_CANCEL_OPTION);
		            }
		            taMessage.setText("");
			        }
			    
			} else {
			    JOptionPane.showMessageDialog(PhoneBookFrame.this, name + "님의 정보가 없습니다.", "알림", JOptionPane.OK_CANCEL_OPTION);
			}
			    
			return;
			    
		}
			
		// ----------- 종료 -----------
		} else if (obj == btnExit || obj == miExit) {
			int result = JOptionPane.showConfirmDialog(PhoneBookFrame.this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else if (result == JOptionPane.NO_OPTION) {
				return;
			}
			
		}
	}
	
	class InputDialog extends JDialog implements ActionListener {
		JTextField tfName = new JTextField();
		JTextField tfPhoneNumber = new JTextField();
		JTextField tfBirdthDay = new JTextField();
		JRadioButton rdoSchool = new JRadioButton("학교", true);
		JRadioButton rdoCompany = new JRadioButton("회사");
		JTextField tfSchoolOrCompanyName = new JTextField();
		JButton btnFinish = new JButton("입력완료");
		JButton btnCancel = new JButton("취소");
		
		public InputDialog(JFrame owner, String title, boolean isModal) {
			super(owner, title, isModal);
			setSize(300, 250);
			setLocationRelativeTo(owner);
			
			setLayout(new GridLayout(5, 2, 10, 10));
			add(new JLabel("이름"));
			add(tfName);
			add(new JLabel("전화번호"));
			add(tfPhoneNumber);
			add(new JLabel("생일"));
			add(tfBirdthDay);
			JPanel pnlSchoolOrCompany = new JPanel();
			ButtonGroup groupSchoolOrCompany = new ButtonGroup();
			pnlSchoolOrCompany.add(rdoSchool);
			pnlSchoolOrCompany.add(rdoCompany);
			groupSchoolOrCompany.add(rdoSchool);
			groupSchoolOrCompany.add(rdoCompany);
			add(pnlSchoolOrCompany);
			add(tfSchoolOrCompanyName);
			add(btnFinish);
			add(btnCancel);
			
			btnFinish.addActionListener(this);
			btnCancel.addActionListener(this);
			
		}
		
		public void resetFields() {
		        tfName.setText("");
		        tfPhoneNumber.setText("");
		        tfBirdthDay.setText("");
		        tfSchoolOrCompanyName.setText("");
		        rdoSchool.setSelected(true);
		}
		
		public void setInputOrUpdate(String title) {
			setTitle(title);
			btnFinish.setText(title + "완료");
		}
		
		public void setDelete(String title) {
			setTitle(title);
		}
		
		
		public void setInfo(PhoneInfo info) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompany = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompany = ((PhoneInfoSchool)info).getSchool();
				rdoSchool.setSelected(true);
			} else if (info instanceof PhoneInfoCompany) {
				schoolOrCompany = ((PhoneInfoCompany)info).getCompany();
				rdoCompany.setSelected(true);
			}
			tfName.setText(name);
			tfPhoneNumber.setText(phoneNumber);
			tfBirdthDay.setText(birthDay);
			tfSchoolOrCompanyName.setText(schoolOrCompany);
		}

		private PhoneInfo makePhoneInfo() {
			String name = tfName.getText();
			String phoneNumber = tfPhoneNumber.getText();
			String birthDay = tfBirdthDay.getText();
			String schoolOrCompanyName = tfSchoolOrCompanyName.getText();
			PhoneInfo info = null;
			if (rdoSchool.isSelected()) {
				info = new PhoneInfoSchool(name, phoneNumber, birthDay, schoolOrCompanyName);
			} else {
				info = new PhoneInfoCompany(name, phoneNumber, birthDay, schoolOrCompanyName);
			}
			return info;
		}
		
		private void showMessage(String message) {
			JOptionPane.showMessageDialog(PhoneBookFrame.this, message, "알림", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnFinish) {
				PhoneInfo info = this.makePhoneInfo();
				boolean result = book.addInfo(info);
				if (result) {
					showMessage("데이터 입력 완료");
				} else {
					showMessage("데이터 입력 실패");
				}
			} else if (obj == btnCancel) {
				
			}
			
			this.setVisible(false);
			
		}
				
	}
	
}
