package algo_day_15;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();	//물건개수
			int K = sc.nextInt();	//부피한도
			
			int[][] item = new int[N][2];
			int[] backpack = new int[K+1];
			for(int i=0;i<item.length;i++) {
				item[i][0] = sc.nextInt();	//부피 
				item[i][1] = sc.nextInt();	//가치
			}
			for(int i=0;i<N;i++) {
				for(int j=backpack.length-1;j>=item[i][0];j--) {
					backpack[j] = Math.max(backpack[j],backpack[j-item[i][0]]+item[i][1] );
				}
			}
			System.out.println("#"+tc+" "+backpack[backpack.length-1]);
		}
	}
}
