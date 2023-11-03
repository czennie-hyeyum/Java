package guessnum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNumFrame extends JFrame implements ActionListener {
	private GameManager manager = GameManager.getInstance();
	private static final String START_MESSAGE 
		= "1~100 사이의 임의의 숫자를 맞춰보세요.";
	private Container con = getContentPane();
	
	// North
	private JPanel pnlNorth = new JPanel();
	private JTextField tfInput = new JTextField(4);
	private JLabel lblInput = new JLabel("입력:");
	private JButton btnInput = new JButton("입력");
	private JLabel lblRecord = new JLabel("기록:");
	private JTextField tfRecord = new JTextField("30000");
	private JButton btnNewGame = new JButton("새게임");
	
	
	// Center
	private JTextArea taMessage = new JTextArea(START_MESSAGE);
	
	// South
	private JPanel pnlSouth = new JPanel();
	private TimePanel pnlTime = new TimePanel();
	private JLabel lblCount = new JLabel("남은 횟수:");
	private JLabel lblTime = new JLabel("남은 시간:");
	private JTextField tfTime = new JTextField();
	
	private long startTime;
	private long endTime;
	
	public GuessNumFrame( ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자맞추기");
		setSize(600, 400);
		setUI();
		setListener();
		init();
		
		setVisible(true);
	}
	
	private void exitOneGame() {
		tfInput.setEnabled(false);
		btnInput.setEnabled(false);
	}

	private void setListener() {
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnNewGame.addActionListener(this);
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setSouth() {
		pnlSouth.setBackground(Color.CYAN);
		pnlSouth.add(lblCount);
		pnlSouth.add(tfTime);
		pnlSouth.add(lblTime);
		pnlSouth.add(pnlTime);
		pnlTime.setBounds(0, 0, 600, 40);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	}

	private void setNorth() {
		pnlNorth.setBackground(Color.PINK);
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		pnlNorth.add(btnInput);
		pnlNorth.add(lblRecord);
		pnlNorth.add(tfRecord);
		pnlNorth.add(btnNewGame);
		con.add(pnlNorth, BorderLayout.NORTH);
	}
	
	private void init() {
		manager.init();
		tfInput.setEnabled(true);
		btnInput.setEnabled(true);
		tfRecord.setEditable(false);
		taMessage.setEditable(false);
		tfTime.setEditable(false);
		taMessage.setText(START_MESSAGE);
		printHeart();
		startTime = System.currentTimeMillis();
	}
	
	public class TimePanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	public static void main(String[] args) {
		new GuessNumFrame();
		
	}
	
	private void printHeart() {
		int count = manager.getCount();
		String heart = "";
		for (int i = 0; i < count; i++) {
			heart += "♥";
		}
		tfTime.setText(heart);
	}
	
	private void updateRecord() {
		long elapsedTime = endTime - startTime;
		String strRecord = tfRecord.getText();
		long lRecord = Long.parseLong(strRecord);
		if (elapsedTime < lRecord) {
			tfRecord.setText(String.valueOf(elapsedTime));
		}
	}
	

	private void appendMessage(int result, int userNum) {
		String resultMessage = "";
		switch (result) {
			case GameManager.RESULT_OK:
				JOptionPane.showMessageDialog(GuessNumFrame.this, "정답입니다!", "알림", JOptionPane.OK_CANCEL_OPTION);
				exitOneGame();
				endTime = System.currentTimeMillis();
				updateRecord();
				break;
			case GameManager.RESULT_BIG:
				JOptionPane.showMessageDialog(GuessNumFrame.this,  userNum + "보다 큽니다.", "알림", JOptionPane.OK_CANCEL_OPTION);
				break;
			case GameManager.RESULT_SMALL:
				JOptionPane.showMessageDialog(GuessNumFrame.this, userNum + "보다 작습니다.", "알림", JOptionPane.OK_CANCEL_OPTION);
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
				JOptionPane.showMessageDialog(GuessNumFrame.this, 
						"기회를 모두 소진하였습니다.", "알림", JOptionPane.ERROR_MESSAGE);
				exitOneGame();
			}
			printHeart();
			tfInput.setText("");
		} else if (obj == btnNewGame) {
			init();
		}
		
	}

}