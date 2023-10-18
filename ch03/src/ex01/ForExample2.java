package ex01;

public class ForExample2 {

	public static void main(String[] args) {
		
		//
		int sumOdd = 0; //홀수의 합 변수
		int sumEven = 0; //짝수의 합 변수
		
		for (int count = 1; count <= 100; count++) {
			if (count % 2 == 1){ //홀수라인
				sumOdd += count;
			} else { //짝수라인
				sumEven += count;
			}
		}	
		System.out.println(" 홀수의 합: " + sumOdd);
		System.out.println(" 짝수의 합: " + sumEven);
		System.out.println(" 전체 합: " + (sumOdd + sumEven));
		
	
	}

}
