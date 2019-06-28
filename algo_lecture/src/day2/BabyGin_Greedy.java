package algo_day2;

public class BabyGin_Greedy {
	public static void main(String[] args) {
		
		
//		int m = 5;
//		int n = 3;
//		if( m < 1 & n++ == 3) {
//			System.out.println("???");
//		}
//		System.out.println(m);
//		System.out.println(n);
			
		
		int[] arr = {7,7,7,7,8,9};
		int[] counts = new int[10];
		for(int i = 0; i < arr.length; i++)
			counts[ arr[i] ]++;
		
		int idx = 0;
		int isBabyGin = 0;
		for(int i = 0; i < counts.length; i++) {
			if (counts[i] >= 3) {
				counts[i] -= 3;
				isBabyGin++;
				i--;
			}
			if (i < 8 && counts[i] >= 1 && counts[i + 1] >= 1 && counts[i + 2] >= 1) {
				counts[i]--;
				counts[i + 1]--;
				counts[i + 2]--;
				isBabyGin++;
				i--;
			}
		}
		if( isBabyGin == 2 )
			System.out.println("BabyGin!!!");
		else
			System.out.println("Nope!");
		
		
//		while(idx != 10) {
//			
//			//triplet검사.
//			if( counts[idx] >= 3 ) {
//				counts[idx] -= 3;
//				isBabyGin++;
//				continue;
//			}
//			if( counts[idx] >= 1 && counts[idx-1] >= 1 && counts[idx-2] >= 1) {
//				counts[idx]--;
//				counts[idx-1]--;
//				counts[idx-2]--;
//				isBabyGin++;
//				continue;
//			}
//			idx++;
//		}
//		if( isBabyGin == 2 )
//			System.out.println("BabyGin!!!");
//		else
//			System.out.println("Nope!");
	}
}
