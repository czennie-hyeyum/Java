package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx extends JFrame {
	Container con = getContentPane();
	JLabel label = new JLabel("<Enter>키로 배경색이 바뀝니다.");
	
	public KeyListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("키 리스너 예제");
		setSize(500, 500);
		setVisible(true);
		con.setLayout(new FlowLayout());
		con.add(label);
		con.addKeyListener(new MyKeyAdapter());
		
		// 레이블 기본 투명 상태 - > 불투명하게
		label.setOpaque(true);
		label.setBackground(Color.YELLOW);
		
		// 키 이벤트 받을 조건
		con.setFocusable(true);
		con.requestFocus();
		
	}
	
	class MyKeyAdapter extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			char ch = e.getKeyChar();
			if(ch == '\n') {
				int r = (int)(Math.random() * 256);
				int g = (int)(Math.random() * 256);
				int b = (int)(Math.random() * 256);
				Color newColor = new Color(r, g, b);
				con.setBackground(newColor);
				label.setText("rgb=" + r + ", green=" + g + ", blue=" + b);
			} else if (ch == 'q') {
				System.exit(0);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("키보드 눌림");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("키보드 뗌");
		}
		
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
