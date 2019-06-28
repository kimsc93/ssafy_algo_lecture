package algo_day_16;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] result = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0;i<arr.length;i++) {
				result[i]=1;
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j] && 1+result[j]>result[i]) {
						result[i] = result[j]+1;
					}
					
				}
			}
			Arrays.sort(result);
			System.out.println(result[result.length-1]);
		}
		
	}
}
