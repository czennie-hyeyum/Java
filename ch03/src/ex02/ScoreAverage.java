package ex02;

public class ScoreAverage {

	public static void main(String[] args) {
		int[][] scores = {{100, 90, 80}, //scores[0] 270
						  {90, 80, 70},  //scores[1] 240
						  {80, 70, 60},  //scores[2] 210
						  {70, 60, 50} }; //scores[3] 180
		
		System.out.println(scores[0][1]);
		System.out.println(scores[1][1]); 
		System.out.println(scores[3][1]); 
		
		int total = 0;
		for (int j = 0; j < scores.length; j++) {
			for (int i = 0; i < scores[j].length; i++) {
				total += scores[j][i];
			}
		}	
		
		/*
		for(int i = 0; i < scores[1].length; i++) {
			total += scores[1][i];
		}	
		*/	
		
		System.out.println("total:" + total);
		
		int totalLength = 0;
		for (int i = 0; i < scores.length; i++) {
				totalLength += scores[i].length;
		}
			
		System.out.println("average:" + ((double)total / totalLength));
	}
}
