package guessnum2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNumFrame extends JFrame implements ActionListener {
	private static final int MIN_SCORE = 30000;
	private RecordDialog recordDialog = new RecordDialog(this, "기록", true);
	private ScoreDao scoreDao = ScoreDao.getInstance();
	private GameManager manager = GameManager.getInstance();
	private static final String START_MESSAGE 
		= "1~100 사이의 임의의 숫자를 맞춰보세요\n-----기회는 5번입니다.-----";
	private Container con = getContentPane();
	// North
	private JPanel pnlNorth = new JPanel();
	private JTextField tfInput = new JTextField(5);
	private JButton btnInput = new JButton("입력");
	private JLabel lblRecord = new JLabel("기록:");
	private JTextField tfRecord = new JTextField("30000");
	private JButton btnRecord = new JButton("기록보기");
	private JButton btnNewGame = new JButton("새게임");
	
	// Center
	private JTextArea taMessage = new JTextArea(START_MESSAGE);
	
	// South
	private JPanel pnlSouth = new JPanel();
	private JLabel lblCount = new JLabel("남은횟수:");
	private JTextField tfCount = new JTextField(7);
	
	private long startTime;	
	private long endTime;
	
	private UserVo loginVo;
	
	public GuessNumFrame(UserVo userVo) {
		this.loginVo = userVo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자맞추기 - " + loginVo.getUserId() + "(" + loginVo.getUserId() + ")");
		setSize(700, 500);
		setUI();
		setListener();
		setVisible(true);
		init();
	}
	
	private void exitOneGame() {
		tfInput.setEnabled(false);
		btnInput.setEnabled(false);
		tfInput.setEnabled(true);
	    btnInput.setEnabled(true);
	}

	private void setListener() {
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnNewGame.addActionListener(this);
		btnRecord.addActionListener(this);
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setSouth() {
		pnlSouth.setBackground(Color.CYAN);
		pnlSouth.add(lblCount);
		pnlSouth.add(tfCount);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	}

	private void setNorth() {
	    pnlNorth.setBackground(Color.YELLOW);
	    pnlNorth.add(tfInput);
	    pnlNorth.add(btnInput);
	    pnlNorth.add(lblRecord);
	    int minScore = scoreDao.getMinScore();
	    tfRecord.setText(String.valueOf(minScore));
	    pnlNorth.add(tfRecord);
	    pnlNorth.add(btnRecord);
	    pnlNorth.add(btnNewGame);
	    con.add(pnlNorth, BorderLayout.NORTH);
	}
	
	private void init() {
		manager.init();
		tfInput.setEnabled(true);
		btnInput.setEnabled(true);
		tfRecord.setEditable(false);
		taMessage.setEditable(false);
		tfCount.setEditable(false);
		taMessage.setText(START_MESSAGE);
		printHeart();
		startTime = System.currentTimeMillis();
	}

	private void printHeart() {
		int count = manager.getCount();
		String heart = "";
		for (int i = 0; i < count; i++) {
			heart += "♥";
		}
		tfCount.setText(heart);
	}
	
	private void updateRecord() {
		long score = endTime - startTime;
		if (score > MIN_SCORE) {
			return;
		}
//		ScoreVo scoreVo = new ScoreVo(username, (int)score);
		ScoreVo scoreVo = new ScoreVo();
		scoreVo.setUserId(loginVo.getUserId());
		scoreVo.setScore((int)score);
		boolean result = scoreDao.addScore(scoreVo);
		System.out.println("add score result:" + result);
		
		if (result) {
			JOptionPane.showMessageDialog(null, "기록 입력 완료", 
					"알림", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "기록 입력 실패", 
					"알림", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void appendMessage(int result, int userNum) {
		String resultMessage = "";
		switch (result) {
			case GameManager.RESULT_OK:
				resultMessage = "----- 정답입니다. -----";
				exitOneGame();
				endTime = System.currentTimeMillis();
				updateRecord();
				break;
			case GameManager.RESULT_BIG:
				resultMessage = "----- " + userNum + " 보다 큽니다. -----";
				break;
			case GameManager.RESULT_SMALL:
				resultMessage = "----- " + userNum + " 보다 작습니다. -----";
				break;
		} // switch
		taMessage.append("\n" + resultMessage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfInput || obj == btnInput) {
			String userInput = tfInput.getText();
			try {
				int userNum = Integer.parseInt(userInput);
				System.out.println(userNum);
				if (userNum < 1 || userNum > 100) {
					JOptionPane.showMessageDialog(
							GuessNumFrame.this, "1~100 사이의 숫자를 입력해주세요.", 
							"알림", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int result = manager.judge(userNum);
				appendMessage(result, userNum);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(
						GuessNumFrame.this, "숫자만 입력해 주세요", 
						"알림", JOptionPane.ERROR_MESSAGE);
				tfInput.setText("");
				return;
			}
			
			int count = manager.getCount();
			if (count == 0) {
				taMessage.append("\n 기회를 모두 소진하였습니다.");
				exitOneGame();
			}
			printHeart();
			tfInput.setText("");
		} else if (obj == btnNewGame) {
			init();
		} else if (obj == btnRecord) {
			recordDialog.setVisible(true);
		}
		
	}
	
	class RecordDialog extends JDialog implements ActionListener {
		private JTextArea record = new JTextArea();
		
		public RecordDialog(JFrame record, String title, boolean isModal) {
			super(record, title, isModal);
			setSize(400, 300);
			setUI();
			setLocationRelativeTo(record);
		}
		
		private void setUI() {
			add(new JScrollPane(record), BorderLayout.CENTER);
			record.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}

}