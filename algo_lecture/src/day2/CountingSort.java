package algo_day2;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		// 메모리 절약 하려면 min max활용 8 - 2 + 1   7칸 배열. 각각의 위치는  n-2
		
		int max = 8;
		int min = 2;
		int[] arr = { 8, 5, 6, 3, 2, 4, 5, 7 };
		int[] counts = new int[ max - min + 1 ];
		for(int i = 0; i < arr.length; i++) {
			counts[ arr[i] - min ]++;
		}
		for(int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		int[] sorted_arr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i] + " 의 위치 : " + (counts[arr[i]] -1) );
//			counts[arr[i]]--;
			sorted_arr[ --counts[ arr[i] - min ] ] = arr[i];

		}
		System.out.println(Arrays.toString(sorted_arr));
	}
}
