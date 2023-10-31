package oc;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class CatchingGame extends JFrame {
	private Container con = getContentPane();
	private ImageIcon iconRight = new ImageIcon("images/right.png");
	private ImageIcon iconLeft = new ImageIcon("images/left.png");
	private ImageIcon iconMonster = new ImageIcon("images/monster.png");
	private MonsterLabel lblMonster = new MonsterLabel(iconMonster);
	private JLabel lblAvatar = new JLabel(new ImageIcon("images/right.png"));
	private static final int MOVE_UNIT = 10;
	
	public CatchingGame() {
		super("키보드로 이미지 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		con.setLayout(null);
		lblAvatar.setBounds(50, 50, 45, 45);
		lblMonster.setBounds(200, 200, 45, 45);
		con.add(lblAvatar);
		con.add(lblMonster);
		con.addKeyListener(new MyKeyAdapter());
		con.setFocusCycleRoot(true);
		con.requestFocus();
		
		Thread th = new Thread(lblMonster);
		th.start();
	}
	
	class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			int avatarX = lblAvatar.getX();
			int avatarY = lblAvatar.getY();
			int maxX = con.getWidth() - lblAvatar.getWidth();
			int maxY = con.getHeight() - lblAvatar.getHeight();
				
			switch(keyCode) {
			case KeyEvent.VK_UP:
				avatarY -= MOVE_UNIT;
				if(avatarY < 0) {
					avatarY = 0;
				}
				break;
				
			case KeyEvent.VK_DOWN:
				avatarY += MOVE_UNIT;
				if(avatarY > maxY) {
					avatarY = maxY;
				}
				break;
				
			case KeyEvent.VK_LEFT:
				lblAvatar.setIcon(iconLeft);
				avatarX -= MOVE_UNIT;
				if(avatarX < 0) {
					avatarX = 0;
				} 
				break;
				
			case KeyEvent.VK_RIGHT:
				lblAvatar.setIcon(iconRight);
				avatarX += MOVE_UNIT;
				if(avatarX > maxX) {
					avatarX = maxX;
				}
				break;
				
			case KeyEvent.VK_Q:
				System.exit(0);
				break;
			}
			
			lblAvatar.setLocation(avatarX, avatarY);
			
		}
	}
	

	public static void main(String[] args) {
		new CatchingGame();
	}
	
	public class MonsterLabel extends JLabel implements Runnable {
		private static final int MOVE_UNIT = 5;
		
		public MonsterLabel(ImageIcon icon) {
			super(icon);
	    }

		@Override
		public void run() {
			
			 while (true) {
				 	int avatarX = lblAvatar.getX();
					int avatarY = lblAvatar.getY();
				 	int monsterX = getX();
					int monsterY = getY();
					
					if (avatarX > monsterX) {
		            	monsterX += MOVE_UNIT;
		            } else if (avatarX < monsterX) {
		            	monsterX -= MOVE_UNIT;
		            }
					
					if (avatarY > monsterY) {
					  	monsterY += MOVE_UNIT;
		            } else if (avatarY < monsterY) {
		            	monsterY -= MOVE_UNIT;
		            }
			            
				 	setLocation(monsterX, monsterY);
				 	
				 	 if (Math.abs(monsterX - avatarX) <= 35 && Math.abs(monsterY - avatarY) <= 35) {
	                break;
	                
				 	 }
				 	
				 try {
					 Thread.sleep(200);
				} 
				 
				 catch (InterruptedException e) {
					return;
				}
				 
		     } // while
			 
		}
		
	}

}
