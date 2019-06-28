package algo_day_11;

import java.util.Arrays;

public class combination {
	public static void main(String[] args) {
		
		combin(new int[] {1,3,7,9},new int[3],0,0);
		
	}
	public static void combin(int[] arr,int[] sel,int n,int r) {
		
		if(sel.length ==r) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(arr.length ==n) {
			return;
		}
		sel[r] = arr[n];
		combin(arr,sel,n+1,r+1);
		combin(arr,sel,n+1,r);
	}
}
