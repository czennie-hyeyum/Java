package prac1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Diamond10 extends JFrame {
	PaintPanel panel = new PaintPanel();
	
	public Diamond10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다이아몬드 10개");
		setSize(500, 500);
		setContentPane(panel);
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		private static final int DIAMONDS = 10;
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int panelX = this.getWidth() / 2;
			int panelY = this.getHeight() / 2;
			
			int diamondSize = 50;
			
			for(int i = 0; i < DIAMONDS; i++) {
				int centerX = panelX - diamondSize;
				int centerY = panelY - diamondSize;
				int [] x = { panelX, centerX, panelX, panelX + diamondSize, panelX };
				int [] y = { centerY, panelY, panelY + diamondSize, panelY, centerY };
				g.setColor(Color.BLACK);
				g.drawPolygon(x, y, 4);
				diamondSize += 20;
			}
			
			
		}
	}

	public static void main(String[] args) {
		new Diamond10();
	}

}
