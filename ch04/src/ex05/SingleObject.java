package ex05;

public class SingleObject {
	private static SingleObject instance; // 기본값 null
	
	private SingleObject() { /* singleton */ }
		
	public static SingleObject getInstance() {
		if (instance == null) {
			instance = new SingleObject();
		}
		
		return instance;
	}
}
