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
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PieChart extends JFrame {
	private String[] fruits = {"apple", "cherry", "strawberry", "prune"};
	private JTextField[] tfFruits = new JTextField[fruits.length];
	private int[] saleCounts = new int[fruits.length];
	private int[] percents = new int[fruits.length];
	private int[] angles = new int[fruits.length];
	private Container con = getContentPane();
	private InputPanel pnlInput = new InputPanel();
	private ResultPanel pnlResult = new ResultPanel();
	
	
	public PieChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("파이 차트 그리기");
		setSize(700, 500);
		setUI();
		setVisible(true);
	
	}
	
	public void setUI() {
		con.add(pnlInput, BorderLayout.NORTH);
		con.add(pnlResult, BorderLayout.CENTER);
	}
	
	public class InputPanel extends JPanel implements ActionListener {
		
		public InputPanel() {
			setBackground(Color.LIGHT_GRAY);
			
			for (int i = 0; i < fruits.length; i++) {
				JLabel lblFruits = new JLabel(fruits[i]);
				JTextField tf = new JTextField(7);
				tfFruits[i] = tf;
				add(lblFruits);
				add(tf);
				tf.addActionListener(this);
			}
			
		}
		
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == saleCounts) {
				
			}
		}
		
	}
	
	public class ResultPanel extends JPanel {
		private Color[] colors = {
						Color.RED,
						Color.BLUE,
						Color.MAGENTA,
						Color.YELLOW
		};
		
		public ResultPanel() {
			setBackground(Color.WHITE);
		}
		
		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
					g.setFont(new Font("Arial", Font.ITALIC, 10));
					
			}
			
		
	}
	

	public static void main(String[] args) {
		new PieChart();
	}

}
