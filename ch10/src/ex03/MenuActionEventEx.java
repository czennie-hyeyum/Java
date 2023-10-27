package ex03;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuActionEventEx extends JFrame {
	private Container con = getContentPane();
	private Vector<JMenuItem> vecItem = new Vector<>(); 
	
	public MenuActionEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴 예제");
		setSize(500, 500);
		createMenu();
		setListener();
		setVisible(true);
	}

	private void setListener() {
		for(int i = 0; i < vecItem.size(); i++) {
			JMenuItem item = vecItem.get(i);
			item.addActionListener(null);
		}
	}

	private void createMenu() {
		// 메뉴바 - 프레임에 붙일 것
		JMenuBar menuBar = new JMenuBar();
		
		// 메뉴 - 메뉴바에 붙일 것
		JMenu mnuScreen = new JMenu("Screen");
		JMenu mnuEdit = new JMenu("Edit");
		JMenu mnuSource = new JMenu("Source");
		JMenu mnuProject = new JMenu("Project");
		JMenu mnuRun = new JMenu("Run");
		
		// 메뉴바에 메뉴들 붙이기
		menuBar.add(mnuScreen);
		menuBar.add(mnuEdit);
		menuBar.add(mnuSource);
		menuBar.add(mnuProject);
		menuBar.add(mnuRun);
		
		// Screen 메뉴에 붙일 아이템들
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miHide = new JMenuItem("Hide");
		JMenuItem miReShow = new JMenuItem("ReShow");
		JMenuItem miExit = new JMenuItem("Exit");
		
		// 메뉴 아이템들 Vector에 넣기
		vecItem.add(miLoad);
		vecItem.add(miHide);
		vecItem.add(miReShow);
		vecItem.add(miExit);
		
		// Screen 메뉴에 아이템 달기
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.add(miReShow);
		mnuScreen.addSeparator(); // 분리선(구분선)
		mnuScreen.add(miExit);
		
		// 프레임에 메뉴바 붙이기
		setJMenuBar(menuBar);
		
	}

	public static void main(String[] args) {
		new MenuActionEventEx();
	}

}
