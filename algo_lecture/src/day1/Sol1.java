package com.ssafy.algo;

import java.util.Scanner;

public class Sol1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nums[] = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		//버블정렬
		//첫번째녀석이 두번째 녀석보다 더 큰지 비교해서 첫번째가 더 크면 두번째와 교환
		//두번째녀석이 세번째 녀석보다 더 큰지 비교해서 두번째가 더 크면 세번째와 교환
		//....
		//....
		//n-1번째녀석이 n번째 녀석보다 더 큰지 비교해서 n-1번째가 더 크면 n번째와 교환
		
		//첫번째녀석이 두번째 녀석보다 더 큰지 비교해서 첫번째가 더 크면 두번째와 교환
		//두번째녀석이 세번째 녀석보다 더 큰지 비교해서 두번째가 더 크면 세번째와 교환
		//....
		//....
		//n-2번째녀석이 n-1번째 녀석보다 더 큰지 비교해서 n-2번째가 더 크면 n-1번째와 교환
		
		
		for(int j = 0; j < nums.length; j++) {
			for(int i = 0; i < nums.length-1-j; i++) {
				if( nums[i] > nums[i+1] ) {
					int tmp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = tmp;
				}
			}
		}
		
		
		
		
		
//		for (int j = 0; j < nums.length; j++) {
//			int min = nums[j];
//			int minIndex = j;
//			for (int i = j; i < nums.length; i++) {
//				if (min > nums[i]) {
//					min = nums[i];
//					minIndex = i;
//				}
//			}
//
//			int tmp = nums[minIndex];
//			nums[minIndex] = nums[j];
//			nums[j] = tmp;
//		}

		System.out.println(nums[(N - 1) / 2]);

	}
}
