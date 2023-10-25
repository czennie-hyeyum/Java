package guessnum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNumFrame extends JFrame {
	private Container con = getContentPane();
	private NorthPanel pnlMenu = new NorthPanel();
	private SouthPanel pnlCount = new SouthPanel();
	private static JTextArea taRule = new JTextArea(45, 45);
	
	public GuessNumFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자 맞추기");
		setSize(500, 500);
		setUI();
		
		setVisible(true);
	}
	
	private void setUI() {
		// NORTH
		pnlMenu.setBackground(Color.YELLOW);
		con.add(pnlMenu, BorderLayout.NORTH);
		
		// CENTER
		taRule.setText("1 ~ 100 사이의 임의의 숫자를 맞춰보세요. \n ----- 기회는 5번 입니다. ----- \n");
		taRule.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		taRule.setEditable(false);
		con.add(new JScrollPane(taRule), BorderLayout.CENTER);
		
		// SOUTH
		pnlCount.setBackground(Color.CYAN);
		con.add(pnlCount, BorderLayout.SOUTH);
	}
	
	public class SouthPanel extends JPanel {
		private JLabel lblCount = new JLabel("남은 횟수 ");
		private JTextField tfCount = new JTextField("♥♥♥♥♥");
		
		public SouthPanel() {
			lblCount.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			tfCount.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			tfCount.setEditable(false);
			add(lblCount);
			add(tfCount);
		}
		
	}
	
	
	public class NorthPanel extends JPanel implements ActionListener {
		private static JTextField tfNum = new JTextField(5);
		private JButton btnStart = new JButton("입력");
		private JLabel lblNone = new JLabel("        ");
		private JLabel lblRecord = new JLabel("기록:");
		private JTextField tfRecord = new JTextField(10);
		private JButton btnReset = new JButton("새게임");
		
		public NorthPanel() {
			add(tfNum);
			add(btnStart);
			add(lblNone);
			add(lblRecord);
			add(tfRecord);
			tfRecord.setEditable(false);
			add(btnReset);
			tfNum.addActionListener(this);
			btnStart.addActionListener(this);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int targetNum = (int)(Math.random() * 100) + 1;	
			int userNum = Integer.parseInt(tfNum.getText());
			taRule.append(targetNum + "\n");
			
			if(targetNum == userNum) {
				taRule.append("정답입니다.");
			} else if(targetNum > userNum) {
				taRule.append(userNum + "보다 큽니다.\n");
			} else if(targetNum < userNum){
				taRule.append(userNum + "보다 작습니다.\n");
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new GuessNumFrame();
	}

}
