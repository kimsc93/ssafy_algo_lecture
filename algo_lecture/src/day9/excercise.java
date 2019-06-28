package day01;

import java.util.Arrays;

public class excercise {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		perm(arr,0,2);
		
	}
	static void perm(int[] arr,int n,int k) {
		if(n==k) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=n;i<arr.length;i++) {
			swap(arr,n,i);
			perm(arr,n+1,k);
			swap(arr,n,i);
		}		
	}
	static void swap(int[] arr,int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
