package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PieChart extends JFrame implements ActionListener {
	private Container con = getContentPane();
	private String[] fruits = {"apple", "cherry", "strawberry", "prune"};
	private JTextField[] tfFruits = new JTextField[fruits.length];
	private int[] saleCounts = new int[fruits.length];
	private int[] percents = new int[fruits.length];
	private int[] angles = new int[fruits.length];
	private Color[] colors = {
			Color.RED, Color.BLUE, Color.MAGENTA, Color.YELLOW
	};
	private InputPanel pnlInput = new InputPanel();
	private ChartPanel pnlChart = new ChartPanel();
	
	
	public PieChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("파이 차트 그리기");
		setSize(600, 450);
		setUI();
		setVisible(true);
	
	}
	
	public void setUI() {
		con.add(pnlInput, BorderLayout.NORTH);
		con.add(pnlChart, BorderLayout.CENTER);
	}
	
	public class InputPanel extends JPanel {
		
		public InputPanel() {
			setBackground(Color.LIGHT_GRAY);
			
			for (int i = 0; i < fruits.length; i++) {
				JLabel lblFruits = new JLabel(fruits[i]);
				JTextField tf = new JTextField(5);
				tfFruits[i] = tf;
				add(lblFruits);
				add(tf);
			}
			
		}
		
	}
	
	public class ChartPanel extends JPanel {
		
		public ChartPanel() {
			setBackground(Color.WHITE);
			
		}
		
		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
				for (int i = 0; i < fruits.length; i++) {
					g.setColor(colors[i]);
					g.setFont(new Font("Arial", Font.ITALIC, 10));
					g.drawString(fruits[i] + " " + percents[i] + "%", 100 + (i * 130), 50);
				}
					
			}
			
	}
	

	public static void main(String[] args) {
		new PieChart();
	}
	
	public void actionPerformed(ActionEvent e) {
			int total = getTotal();
			setPercents(total);
			setAngles(total);
		
	}
	
	private void showPercentsAndAngles() {
		System.out.println("percents");
		for (int i = 0; i < percents.length; i++) {
			System.out.printf("%d%% \n", percents[i]);
		}
		System.out.println("angles");
		for (int i = 0; i < angles.length; i++) {
			System.out.printf("%d%도", angles[i]);
		}
		
	}
	
	private void setAngles(int total) {
		for (int i = 0; i < angles.length; i++) {
			percents[1] = 360 * saleCounts[i]/ getTotal();
		}
	}

	private void setPercents(int total) {
		for (int i = 0; i < percents.length; i++) {
			percents[1] = 100 * saleCounts[i]/ getTotal();
		}
	}

	private int getTotal() {
		int total = 0;
		for (int i = 0; i < tfFruits.length; i++) {
			try {
				total += Integer.parseInt(tfFruits[i].getText());
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(PieChart.this, "숫자만 입력해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
			}
		}
		return total;
	}

}
