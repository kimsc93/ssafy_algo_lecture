package day02;
import java.util.Scanner;

public class Solution_6782 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] squareMap = new long[1000001];
		for (int i = 0; i <= 1000000; i++) {
			squareMap[i] = (long) i * i;
		}
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			long ans = 0;
			int tmp = 0;
			if (N == 1)
				ans = 1;
			else {
				while (N != 2) {
//					for (int i = 0; i <= 1000000; i++) {
//						if (N <= squareMap[i]) {
//							tmp = i;
//							break;
//						}
//					}
					tmp = findBinary(squareMap, squareMap.length/2, N);
//					tmp = (int)Math.sqrt(N) +1;
					long dif = squareMap[tmp] - N;
					ans += dif;

					N = tmp;
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int findBinary(long[] squareMap, int i,long N) {
		int tmp = i;
		int min = 0;
		int max = 1000001;
		while(true) {
			if( squareMap[tmp] < N ) {
				min = tmp;
				tmp = (tmp+max)/2;
			}
			else if( squareMap[tmp] > N) {
				max = tmp;
				tmp = (tmp+min)/2;
			}
			if( squareMap[tmp-1] < N && squareMap[tmp] >= N)
				break;
		}
		return tmp;
	}
}
