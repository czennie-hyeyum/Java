package ex04;

public class Unit {
	private String name;
	private int x;
	private int y;

	public Unit(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		System.out.printf("%s이(가) (%d, %d)으로 이동합니다. \n", name, x, y);
		this.x = x;
		this.y = y;
	}
	
	public void atack(int x, int y) {
		System.out.printf("%s이(가) (%d, %d)를 공격합니다. \n", name, x, y);
	}
	
	public void showPostion() {
		System.out.printf("%s이(가) (%d, %d)에 있습니다. \n", name, x, y);
	}
}
