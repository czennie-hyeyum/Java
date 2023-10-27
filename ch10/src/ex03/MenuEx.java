package ex03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuEx extends JFrame {
	
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴 예제");
		setSize(500, 500);
		createMenu();
		setVisible(true);
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
		new MenuEx();
	}

}
