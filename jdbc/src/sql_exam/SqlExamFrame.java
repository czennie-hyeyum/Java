package sql_exam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SqlExamFrame extends JFrame implements ActionListener {
	Container con = getContentPane();
	StudentDao studentDao = new StudentDao();
	private static final String DELIM = " | ";
	
	// North
	JPanel pnlNorth = new JPanel();
	JButton btnInput = new JButton("입력");
	JButton btnModify = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnGetInfo = new JButton("조회");
	
	// Center
	JTextArea taMessage = new JTextArea();
	
	InputDialog inputDialog = new InputDialog(this, "입력/수정", true);
	
	public SqlExamFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생 관리");
		setSize(600, 400);
		setVisible(true);
		setUI();
		setListener();
		init();
	}
	
	private void setUI() {
		setNorth();
		setCenter();
	}
	
	private void setNorth() {
		pnlNorth.add(btnInput);
		pnlNorth.add(btnModify);
		pnlNorth.add(btnDelete);
		pnlNorth.add(btnGetInfo);
		con.add(pnlNorth, BorderLayout.NORTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage));
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	}
	
	private void setListener() {
		btnInput.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnGetInfo.addActionListener(this);
		
	}
	
	private void init() {
		taMessage.setEditable(false);
		loadStudentData();
	}
	
	public static void main(String[] args) {
		new SqlExamFrame();
	}
	
	private void loadStudentData() {
        Vector<StudentVo> loadedInfo = studentDao.getInfo();
        if (loadedInfo != null && !loadedInfo.isEmpty()) {
            taMessage.setText("");
            printData(loadedInfo);
        } else {
            JOptionPane.showMessageDialog(this, "데이터를 불러오는데 실패했습니다.", "알림", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private void printData(Vector<StudentVo> loadeInfo) {
		taMessage.setText("");
		taMessage.append("학번" + DELIM + "학생명" + DELIM + "학년" + DELIM + "성별" + DELIM + "전공" + DELIM + "점수" + "\n") ;
		for (StudentVo studentVo : loadeInfo) {
			String sno = studentVo.getSno();
			String sname = studentVo.getSname();
			Integer syear = studentVo.getSyear();
			String gender = studentVo.getGender();
			Integer major = studentVo.getMajor();
			Integer score  = studentVo.getScore();
			taMessage.append(sno + DELIM);;
			taMessage.append(sname + DELIM);;
			taMessage.append(syear + DELIM);;
			taMessage.append(gender + DELIM);;
			taMessage.append(major + DELIM);;
			taMessage.append(score +"\n");;
		}
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btnInput) {
            inputDialog.setVisible(true);
            loadStudentData();
            
        } else if (obj == btnModify) {
            String studentNum = JOptionPane.showInputDialog(this, "학번을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
            if (studentNum != null && !studentNum.equals("")) {
            	String keyword = studentVo.getSno;
                inputDialog.setVisible(true);
                loadStudentData(); 
                Vector<StudentVo> vec = studentDao.getInfo();
				if (vec.size() == 0) {
					JOptionPane.showMessageDialog(SqlExamFrame.this, studentNum + "님의 정보가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
            }
            
        } else if (obj == btnDelete) {
            String studentNum = JOptionPane.showInputDialog(this, "학번을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
            if (studentNum != null && !studentNum.equals("")) {
                boolean result = studentDao.delete(studentNum);
                if (result) {
                    JOptionPane.showMessageDialog(this, "삭제가 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                    loadStudentData();
                } else {
                    JOptionPane.showMessageDialog(this, "삭제에 실패했습니다.", "알림", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } else if (obj == btnGetInfo) {
            loadStudentData();
        }
    }
	
	class InputDialog extends JDialog implements ActionListener {
		
		JLabel[] lblInput = { new JLabel("학번"),
							  new JLabel("학생명"),
							  new JLabel("학년"),
							  new JLabel("성별"),
							  new JLabel("전공"),
							  new JLabel("점수"),
							};
		
		// 학년
		String[] yearTexts = {"1", "2", "3", "4"};
		JComboBox<String> comboYear = new JComboBox<>(yearTexts);
		
		// 전공
		String[] majorTexts = {"1", "2", "3", "4"};
		JComboBox<String> comboMajor = new JComboBox<>(majorTexts);
		
		// 성별
		JPanel pnlGender = new JPanel();
		JRadioButton radioMale = new JRadioButton("M");
		JRadioButton radioFemale = new JRadioButton("F", true);
		ButtonGroup genderGroup = new ButtonGroup();
		
		// 학번, 학생명, 점수
		JTextField tfStudentNum = new JTextField();
		JTextField tfStudentName = new JTextField();
		JTextField tfScore = new JTextField();
		
		// 완료, 취소
		JButton btnFinish = new JButton("입력완료");
		JButton btnCancel = new JButton("입력취소");
		
		
		public InputDialog(JFrame owner, String title, boolean modal) {
			super(owner, title, modal);
			setSize(300, 300);
			setUI();
			setListener();
		}	
		
		private void setUI() {
			setLayout(new GridLayout(7, 2));
			
			for (int i = 0; i < lblInput.length; i++) {
				add(lblInput[i]);
				
				if (lblInput[i].getText().equals("학번")) {
					add(tfStudentNum);
					
				} else if (lblInput[i].getText().equals("학생명")) {
					add(tfStudentName);
					
				} else if (lblInput[i].getText().equals("학년")) {
					add(comboYear);
					
				} else if (lblInput[i].getText().equals("성별")) {
					genderGroup.add(radioMale);
					genderGroup.add(radioFemale);
					pnlGender.add(radioMale);
					pnlGender.add(radioFemale);
					add(pnlGender);
					
				} else if (lblInput[i].getText().equals("전공")) {
					add(comboMajor);
					
				} else if (lblInput[i].getText().equals("점수")) {
					add(tfScore);
				}
				
				add(btnFinish);
				add(btnCancel);
					
			}
		}
		
		private void setListener() {
			btnFinish.addActionListener(this);
			btnCancel.addActionListener(this);
		}
		
		public void setStudentInfo(StudentVo studentVo) {
            tfStudentNum.setText(studentVo.getSno());
            tfStudentName.setText(studentVo.getSname());
            comboYear.setSelectedItem(studentVo.getSyear().toString());
            if (studentVo.getGender().equals("M")) {
                radioMale.setSelected(true);
            } else {
                radioFemale.setSelected(true);
            }
            comboMajor.setSelectedItem(studentVo.getMajor().toString());
            tfScore.setText(studentVo.getScore().toString());
        }
		
		private StudentVo makeInfo() {
			String sno = tfStudentNum.getText();
			String sname = tfStudentName.getText();
			Integer syear = Integer.parseInt((String)comboYear.getSelectedItem());
			String gender = (radioMale.isSelected()) ? "M" : "F";
			Integer major = Integer.parseInt((String)comboMajor.getSelectedItem());
			Integer score = Integer.parseInt(tfScore.getText());
			
			return new StudentVo(sno, sname, syear, gender, major, score);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			 Object obj = e.getSource();
	            if (obj == btnFinish) {
	                try {
	                    StudentVo studentVo = makeInfo();
	                    boolean result;
	                    if (studentDao.getInfo() != null) {
	                        result = studentDao.modify(studentVo);
	                    } else {
	                        result = studentDao.addStudent(studentVo);
	                    }
	                    if (result) {
	                        System.out.println(studentVo);
	                        taMessage.append("학생 정보 입력/수정 완료 \n");
	                        loadStudentData();
	                    } else {
	                        taMessage.append("학생 정보 입력/수정 실패 \n");
	                    }
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            } else if (obj == btnCancel) {
	                inputDialog.setVisible(false);
	            }
			
		}
		
	}

} // class
