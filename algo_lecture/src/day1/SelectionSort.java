package com.ssafy.algo;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		//이 친구를 선택정렬해봅시다  :) 
		int[] nums = {4, 2, 5, 1, 7, 9, 6, 3, 8};
		//선택정렬
		//0번째부터 젤 작은 값을 찾아서 0번째와 교환
		//1번쨰부터 젤 작은 값을 찾아서 1번째와 교환
		//...
		//n번째부터 젤 작은 값을 찾아서 n번째와 교환
		
		for(int j = 0; j < nums.length; j++) {
			
			int min = nums[j];
			int minIndex = j;
			for(int i = j; i < nums.length; i++) {
				if( min > nums[i] ) {
					min = nums[i];
					minIndex = i;
				}
			}
			int tmp = nums[minIndex];
			nums[minIndex] = nums[j];
			nums[j] = tmp;
		
		}
		
		System.out.println(Arrays.toString(nums));
		
		
	}
}
