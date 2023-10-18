package ex02;

public class ReturnArray {

	public static void main(String[] args) {
		int[] array = makeArray();
		int[] array2 = makeArray();
		int sum = getSum(array);
		System.out.println("array:" + array);
		System.out.println("array2:" + array2);
		System.out.println("sum:" + sum);
		
		array[0] = 100;
		for (int i : array) {
			System.out.print(i + " ");  
		}
		
		long time = System.currentTimeMillis();
		System.out.println("time:" + time);
	}
	
	public static int[] makeArray() {
		int[] temp = new int[4];
		return temp; // 리턴은 하나만 가능
	}
	
	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
			sum += data[i];
		}
		return sum;
	}
}
