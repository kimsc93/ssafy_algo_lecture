package com.ssafy;

public class ZigZag {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		
		int num = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][  j + ( 5 - 2*j - 1  ) * (i%2)     ] = ++num;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf( "%3d" , arr[i][j]);
			}
			System.out.println();
		}
		
	}
}
