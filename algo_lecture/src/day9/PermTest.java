package day01;

import java.util.Arrays;

public class PermTest {
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static void perm(int[] arr, int k, int n) {
		// System.out.println(Arrays.toString(arr));
		if (k == n) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = k; i < n; i++) {
			swap(arr, i, k);
			perm(arr, k + 1, n);
			swap(arr, i, k);
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		
		perm(arr,0,3);
	}
}
