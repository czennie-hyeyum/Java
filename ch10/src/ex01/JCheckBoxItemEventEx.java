package ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JCheckBoxItemEventEx extends JFrame implements ItemListener {
	private Container con = getContentPane();
	private JPanel pnlCenter = new JPanel(); 
	private JPanel pnlFruitMenu = new JPanel();
	private JPanel pnlResult = new JPanel();
	private JLabel lblFruitMenu = new JLabel("사과 100원, 배 500원, 체리 20000원");
	private JLabel lblResult = new JLabel("현재 0 원입니다.");
	private String[] names = {"사과", "배", "체리"};
	private int[] prices = {100, 500, 20000};
	private JCheckBox[] checks = new JCheckBox[names.length];
	private JLabel sumLabel;
	
	public JCheckBoxItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("아이템 이벤트 예제");
		setSize(500, 300);
		setUI();
		setVisible(true);
		
	}

	private void setUI() {
		// NORTH
		pnlFruitMenu.setBackground(Color.YELLOW);
		pnlFruitMenu.add(lblFruitMenu);
		lblFruitMenu.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(pnlFruitMenu, BorderLayout.NORTH);
		
		pnlCenter.setLayout(new BorderLayout());
		for(int i = 0; i < checks.length; i++) {
			if(!names[i].equals("배")) {
				checks[i] = new JCheckBox(names[i]);
			} else {
				checks[i] = new JCheckBox(names[i], true);
			}
			pnlCenter.add(checks[i]);
			 checks[i].addItemListener(this);
		}
		
		con.add(pnlCenter, BorderLayout.CENTER);
		
		// SOUTH
		pnlResult.setBackground(Color.CYAN);
		pnlResult.add(lblResult);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(pnlResult, BorderLayout.SOUTH);
		
		
	}

	public static void main(String[] args) {
		new JCheckBoxItemEventEx();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int state = e.getStateChange();
		if (state == ItemEvent.SELECTED) {
			Object obj = e.getItem();
			String text = ((JCheckBox)obj).getText();
			System.out.println(text + "이(가) 체크됨");
		}
	}

}
