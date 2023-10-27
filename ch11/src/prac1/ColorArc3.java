package prac1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorArc3 extends JFrame {
	PaintPanel panel = new PaintPanel();
	Container con = getContentPane();
	
	
	public ColorArc3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3색 원형");
		setSize(500, 500);
		setContentPane(panel);
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		private Color[] colors = {
							Color.RED,
							Color.BLUE,
							Color.YELLOW
		};
		private static final int CIRLE_SIZE = 200;
		private int startAngle = 90;
		private int arcAngle = 120;
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int panelX = this.getWidth() / 2;
			int panelY = this.getHeight() / 2;
			
			int centerX = panelX - (CIRLE_SIZE / 2);
			int centerY = panelY - (CIRLE_SIZE / 2);
			
			for(Color color : colors) {
				g.setColor(color);
				g.fillArc(centerX, centerY, CIRLE_SIZE, CIRLE_SIZE, startAngle, arcAngle);
				startAngle += arcAngle;
			}
			
		}

	}

	public static void main(String[] args) {
		new ColorArc3();
	}

}
