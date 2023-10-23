package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NullLayoutEx extends JFrame {
	
	Container con = getContentPane();
	JPanel pnlLeft = new JPanel();
	JPanel pnlRight = new JPanel();
	
	public NullLayoutEx() {
		// 창닫기 버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창제목(널레이아웃 예제)
		setTitle("널레이아웃 예제");
		// 창크기(500 x 500)
		setSize(500, 500);
		
		// UI 설정
		setUI();
		
		// 창보이기
		setVisible(true);
	}

	private void setUI() {
		// 컨테이너의 배치관리자 설정 - 그리드 레이아웃 (1 x 2)
		con.setLayout(new GridLayout(1, 2, 10, 10));
		setLeft();
		setRight();
		// 컨테이너에 패널 달기
		con.add(pnlLeft);
		con.add(pnlRight);
	}
	
	private void setLeft() {
		// 왼쪽 패널의 배치관리자 설정 - 플로우 레이아웃
		pnlLeft.setLayout(new FlowLayout());
		// 왼쪽 패널의 배경색을 오렌지 색으로 설정
		pnlLeft.setBackground(Color.ORANGE);
		// 버튼 두개 달기 - "확인", "취소"
		pnlLeft.add(new JButton("확인"));
		pnlLeft.add(new JButton("취소"));
	}
	
	private void setRight() {
		// 오른쪽 패널의 배치관리자를 없앰
		pnlRight.setLayout(null);
		
		// 오른쪽 패널의 배경색을 녹색으로 설정
		pnlRight.setBackground(Color.GREEN);
		
		// 버튼을 10개 달기
		// 패널에 배치관리자가 없다 -> 버튼들의 크기와 위치 설정
		for (int i = 1; i <= 10; i++) {
			JButton button = new JButton(String.valueOf(i));
			// 크기
			// button.setSize(100, 50);
			// 위치
			// button.setLocation(i * 20, i * 20);
			// 위치, 크기
			button.setBounds(i * 20, i * 20, 100, 50);
			// 패널에 버튼 달기
			pnlRight.add(button);
		}
		
	}

	public static void main(String[] args) {
		new NullLayoutEx();

	}

}