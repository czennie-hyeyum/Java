package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GraphicsDrawMultiShape extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private String[] shapeNames = {"선", "타원", "사각형"};
	private String[] colorNames = {"파랑", "빨강", "보라"};
	private JRadioButton[] rdoShapes = new JRadioButton[shapeNames.length];
	private JRadioButton[] rdoColors = new JRadioButton[colorNames.length];
	private PaintPanel paintPanel = new PaintPanel();
	private static final int LINE = 0;
	private static final int OVAL = 1;
	private static final int RECT = 2;
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int MAGENTA = 2;
	private int curShape = LINE;
	private int curColor = RED;
	private MyMouseAdapter adapter = new MyMouseAdapter();
	private Point startPoint = new Point();
	private Point endPoint = new Point();
	private Vector<MyShape> vecShape = new Vector<MyShape>();
	
	
	public class MyShape {
		private Point startPoint;
		private Point endPoint;
		private int shape;
		private int color;
		
		
		public MyShape(Point startPoint, Point endPoint, int shape, int color) {
				super();
				this.startPoint = startPoint;
				this.endPoint = endPoint;
				this.shape = shape;
				this.color = color;
			}
		
		public Point getStartPoint() {
			return startPoint;
		}

		public void setStartPoint(Point startPoint) {
			this.startPoint = startPoint;
		}

		public Point getEndPoint() {
			return endPoint;
		}

		public void setEndPoint(Point endPoint) {
			this.endPoint = endPoint;
		}

		public int getShape() {
			return shape;
		}

		public void setShape(int shape) {
			this.shape = shape;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}
		
		

	}
	
	
	public class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			startPoint = e.getPoint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			endPoint = e.getPoint();
			paintPanel.repaint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			MyShape shape = new MyShape(startPoint, endPoint, curShape, curColor);
			vecShape.add(shape);
		}
	}
	
	public GraphicsDrawMultiShape() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도형 그리기");
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
	}
	
	private void setListener() {
		for(int i = 0; i < rdoShapes.length; i++) {
			rdoShapes[i].addActionListener(this);
			rdoColors[i].addActionListener(this);
		}
		
		paintPanel.addMouseListener(adapter);
		paintPanel.addMouseMotionListener(adapter);
		
	}
	
	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}
	
	private void setCenter() {
		con.add(paintPanel);
	}
	
	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.CYAN);
		ButtonGroup grpColor = new ButtonGroup();
		for (int i = 0; i < rdoColors.length; i++) {
			rdoColors[i] = new JRadioButton(colorNames[i]);
			pnlSouth.add(rdoColors[i]);
			grpColor.add(rdoColors[i]);
		}
		rdoColors[0].setSelected(true);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void setNorth() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.YELLOW);
		ButtonGroup grpShape = new ButtonGroup();
		for(int i = 0; i < rdoShapes.length; i++) {
			rdoShapes[i] = new JRadioButton(shapeNames[i]);
			pnlNorth.add(rdoShapes[i]);
			grpShape.add(rdoShapes[i]);
		}
		rdoShapes[0].setSelected(true);
		con.add(pnlNorth, BorderLayout.NORTH);
	}
	
	public class PaintPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			switch(curColor) {
			case RED:
					g.setColor(Color.RED);
				break;
				
			case BLUE:
					g.setColor(Color.BLUE);
				break;
				
			case MAGENTA:
					g.setColor(Color.MAGENTA);
				break;
				
			}
			
				
			switch(curShape) {
			case LINE:
				g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
				break;
				
			case OVAL:
				g.drawOval(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
				break;
				
			case RECT:
				g.drawRect(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
				break;
				
			}
			
			
		}
	}
		
	public static void main(String[] args) {
		new GraphicsDrawMultiShape();
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for (int i = 0; i < rdoShapes.length; i++) {
			if (obj == rdoShapes[i]) {
				curShape = i;
				break;
			}
		}
		for (int i = 0; i < rdoColors.length; i++) {
			if (obj == rdoColors[i]) {
				curColor = i;
				break;
			}
		}
	}
	
}
