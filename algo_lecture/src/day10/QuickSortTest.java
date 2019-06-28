package day02;

import java.util.Arrays;

public class QuickSortTest {
	public static void main(String[] args) {
		int[] arr = {3,2,4,6,9,1,8,7,5};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int l, int r) {
		if( l >= r )
			return;
		
		int pivot = partition_lomuto(arr, l, r);
		quickSort(arr, l, pivot - 1);
		quickSort(arr, pivot + 1, r);
	}
	
	static int partition_lomuto(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p;
		for(int j = p; j < r; j++) {
			if( arr[j] <= x ) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i += 1;
			}
		}
		int tmp = arr[i];
		arr[i] = arr[r];
		arr[r] = tmp;
		return i;
	}
	
	
	static int partition(int[] arr, int l, int r) {
		int pivot = (l+r)/2;
		int i = l;
		int j = r;
		while( i <  j ) {
			while( arr[i] < arr[pivot] && i<j ) {
				i++;
			}
			while( arr[j] >= arr[pivot] && i<j) {
				j--;
			}
			if( i < j ) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			if( i == pivot )
				pivot = j;
		}
		int tmp = arr[pivot];
		arr[pivot] = arr[j];
		arr[j] = tmp;
		return j;
	}
}




