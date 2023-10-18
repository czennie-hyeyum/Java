package ex01;

public class RandomEx {

	public static void main(String[] args) {
		//랜덤으로 경우의 수를 부여
		/*
		for(int count = 1; count <= 100; count++) {
			double n = (int)(Math.random() * 6) + 1;
			double j = (int)(Math.random() * 3) + 1;
			
			n *= 6;
			j += 3;
			
			System.out.println((int)n);
		} //for
		*/
		
		/*
		int n = (int)(Math.random() * 500) + 501;
		System.out.println(n);
		*/
		
		int m = (int)(Math.random() * 13) + 1;
		System.out.println(m);
		
	} // main
	
} //class
