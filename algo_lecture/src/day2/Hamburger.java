package algo_day2;

import java.util.Scanner;

public class Hamburger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //재료의 수. 
			int max_cal = sc.nextInt(); // 최대 칼로리
			int[] scores = new int[N];
			int[] cals = new int[N];
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			int max = 0;
			
			// 재료의 종류가 N 
			// N개의 재료 중 p개를 고르는 비트연산ㄱ
			for(int i = 0; i < (1<<N); i++) {
				//이 반복루프마다 새로운 햄버거 타입. 
				int sumS = 0;
				int sumC = 0;
				
				for(int j = 0; j < N; j++) {
					if(  ( ((1 << j) & i) != 0 )  ){
						//j번째 재료가 선택됨.
						sumC += cals[j];
						if(sumC > max_cal)
							break;
						sumS += scores[j];
					}
				}
				if( max < sumS ) {
					max = sumS;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		
		
		
		
		
		
		
		
		
		
		
		// 1 ~ (2의 n제곱 -1) 까지의 숫자를 2진수로 출력해보아요 :)
//		int num = 5;
//		for(int i = 0; i < ( 1 << num ); i++) {
//			for(int j = 0; j < num; j++) {
//				if(  ( ((1 << j) & i) != 0 )  ){
//					System.out.print(j +1 + " ");
//				}
//			}
//			System.out.println();
//		}
	}
}
