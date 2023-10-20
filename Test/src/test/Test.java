package test;

import java.util.Vector;

public abstract class Test {

	public static void main(String[] args) {
		
		Vector<Integer> vec = new Vector<>();
		int test = vec.capacity();
		System.out.println("test: " + test);

	}

}
