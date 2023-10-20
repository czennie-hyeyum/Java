package ex01;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		// Vector - 목록형 컬렉션
		// 순서 o 중복 데이터 o
		
		Vector<Integer> vec1 = new Vector<>();
		// 기본 용량
		int capa = vec1.capacity(); // 허용 용량
		System.out.println("capa: " + capa);
		
		for(int i = 0; i <= capa; i++) {
			// 벡터에 추가(맨뒤에 추가)
			vec1.add(i + 1); // 추가
			
		}
		
		int size = vec1.size(); // 실제 데이터 크기(몇 개인가)
		System.out.println("size: " + size);
		System.out.println("capa: " + vec1.capacity());
		
		System.out.println("--------------------------");
		
		vec1.remove(0); // 제거
		vec1.add(2, 1); // 삽입
		
		for(int i = 0; i < vec1.size(); i++) {
			System.out.println(vec1.get(i)); // 가져오기
		}
		
	}

}
