package ex01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PaintPanelEx extends JFrame {
	PaintPanel panel = new PaintPanel();
	
	public PaintPanelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("사각형 그리기");
		setSize(500, 500);
		setContentPane(panel);
		panel.add(new JButton("그리기"));
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// g - 붓이라고 생각하기
			g.setColor(Color.RED);
			g.drawRect(50, 50, 100, 100);
			g.setColor(Color.BLUE);
			g.drawRect(150, 150, 200, 200);
			
			g.setFont(new FontUIResource("맑은 고딕", Font.ITALIC, 30));
			g.drawString("Hello 헬로우", 250, 250);
			
			g.drawLine(100, 100, 400, 400);
			g.setColor(Color.MAGENTA);
			g.drawOval(50, 50, 100, 100);
			
			g.drawRoundRect(200, 200, 200, 100, 50, 30);
			
			g.fillRect(300, 300, 100, 100);
			g.fillOval(100, 300, 100, 100);
			
			g.drawArc(400, 100, 50, 50, 0, 120); // 0도부터 120도
			g.fillArc(300, 100, 50, 50, 0, 120);
			
			int[] xs = {200, 300, 200, 100};
			int[] ys = {100, 150, 200, 150};
			g.drawPolygon(xs, ys, xs.length);
			
		}
	}

	public static void main(String[] args) {
		new PaintPanelEx();
	}

}
