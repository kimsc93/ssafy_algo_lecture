package day01;

import java.util.Arrays;

public class SelectionSortTest {
	public static void main(String[] args) {
		int[] arr = {4,1,2,3,5};
		recur(arr, 0);
		System.out.println(Arrays.toString(arr));
	}
	static void recur(int[] arr, int idx) {
		if(idx == arr.length)
			return;
		
		//doSomething
		int min_idx = idx;
		for(int i = idx; i < arr.length; i++) {
			if( arr[i] < arr[min_idx] )
				min_idx = i;
		}
		int tmp = arr[min_idx];
		arr[min_idx] = arr[idx];
		arr[idx] = tmp;
		recur(arr, idx+1);
	}
}













