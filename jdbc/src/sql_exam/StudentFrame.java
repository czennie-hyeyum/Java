package sql_exam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {
	private Container con = getContentPane();
	private StudentDao studentDao = StudentDao.getInstance();
	
	// North
	private JPanel pnlNorth = new JPanel();
	private JButton btnInput = new JButton("입력");
	private JButton btnModif = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnGetAll = new JButton("조회");
	
	// Center
	private JTextArea taMessage = new JTextArea();
	
	private InputDialog inputDialog = new InputDialog(this, "입력/수정", true);
	
	public StudentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생 관리");
		setSize(500, 300);
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
		pnlNorth.add(btnModif);
		pnlNorth.add(btnDelete);
		pnlNorth.add(btnGetAll);
		con.add(pnlNorth, BorderLayout.NORTH);
	}
	
	private void setCenter() {
		con.add(taMessage);
	}
	
	private void setListener() {
		btnInput.addActionListener(this);
		btnModif.addActionListener(this);
		btnDelete.addActionListener(this);
		btnGetAll.addActionListener(this);
	}
	
	private void init() {
		taMessage.setEditable(false);
	}
	
	public static void main(String[] args) {
		new StudentFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnInput) {
			inputDialog.setVisible(true);
			
		} else if (obj == btnModif) {
			inputDialog.setVisible(true);
		}
	}
	
	class InputDialog extends JDialog implements ActionListener {
	    
		JLabel[] labels = {
				new JLabel("학번"),
		        new JLabel("학생명"),
		        new JLabel("학년"),
		        new JLabel("성별"),
		        new JLabel("전공"),
		        new JLabel("점수")
		    };
     
		JRadioButton[] rdoButton = {
				new JRadioButton("남자"),
				new JRadioButton("여자", true)
			};
		
		JTextField tfStudentNumber = new JTextField();
		JTextField tfStudentName = new JTextField();
		JTextField tfScore = new JTextField();
		
		ButtonGroup groupGender = new ButtonGroup();
		
		Integer[] syears = {1, 2, 3, 4};
		JComboBox<Integer> syearCombo = new JComboBox<>(syears);
		
		String[] majors = {"경영", "화학", "컴퓨터공학", "피아노"};
		JComboBox<String> majorCombo = new JComboBox<>(majors);
		
		JButton btnFinish = new JButton("입력완료");
		JButton btnCancel = new JButton("입력취소");
		
		private InputDialog(JFrame owner, String title, boolean modal) {
			super(owner, title, modal);
			setSize(300, 300);
			setUI();
			setListener();
		}
		
		private void setUI() {
			setLayout(new BorderLayout());
	         
	 		JPanel pnlGender = new JPanel();
	 		
	 		setLayout(new GridLayout(7, 2)); 
	 	        for (int i = 0; i < labels.length; i++) {
	 	            add(labels[i]);

	 	            if (labels[i].getText().equals("학번")) {
	 	            	add(tfStudentNumber);
	 	                
	 	            } else if (labels[i].getText().equals("학생명")) {
	 	            	add(tfStudentName);
	 	            	
	 		        } else if (labels[i].getText().equals("학년")) {
	 		        	add(syearCombo);
	 		        	
	 		        } else if (labels[i].getText().equals("성별")) {
	 		        		for(JRadioButton radioButton : rdoButton) {
	 		        			radioButton.addActionListener(this);
		 	                    groupGender.add(radioButton);
		 	                    add(radioButton);
		 	                    pnlGender.add(radioButton);
		 	                    add(pnlGender);
		 	                }
	 		                
	 		        } else if (labels[i].getText().equals("전공")) {
	 		        	add(majorCombo);
	 		        	
	 		        } else if (labels[i].getText().equals("점수")) {
	 		        	add(tfScore);
	 		        }
	 	        }
	 	        
	 	        add(btnFinish);
	 	        add(btnCancel);
	 		}
		
		private void setListener() {
			majorCombo.addActionListener(this);
			syearCombo.addActionListener(this);
			btnFinish.addActionListener(this);
			btnCancel.addActionListener(this);
		}
		
		private void setInfo(StudentVo studentVo) {
			Character sNo = studentVo.getSno();
			String sName = studentVo.getSname();
			Integer syear = studentVo.getSyear();
			String gender = studentVo.getGender();
			Integer major = studentVo.getMajor();
			Integer score = studentVo.getScore();
			
			tfStudentNumber.setCharacter(sNo);
		}
		
		private StudentVo makeInfo() {
			String sNumber = tfStudentNumber.getText();
			char sNo = sNumber.charAt(0);
			String sName = tfStudentName.getText();
			Integer syear = (Integer)syearCombo.getSelectedItem();
			String gender = "";
			   for (JRadioButton radioButton : rdoButton) {
			       if (radioButton.isSelected()) {
			           gender = radioButton.getText();
			           break;
			       }
			   }
			   
			int major = Integer.parseInt ((String) majorCombo.getSelectedItem());
			int score = Integer.parseInt(tfScore.getText());

			return new StudentVo(sNo, sName, syear, gender, major, score);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
	        if (obj == btnFinish) {
                try {
                	StudentVo studentVo = makeInfo();
                    boolean result = studentDao.addStudent(studentVo);
                	
                     if (result) {
                        taMessage.append("학생 정보 입력 성공 \n");
                    } else {
                        taMessage.append("학생 정보 입력 실패 \n");
                    }
                } catch (NumberFormatException ex) {
                    taMessage.append("입력이 잘못되었습니다.\n");
                }

            } else if (obj == btnCancel) {
                this.setVisible(false);
            }
		}
	}

} // class
