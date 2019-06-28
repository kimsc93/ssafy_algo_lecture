package com.ssafy;

public class Prac1 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = (int) (Math.random() * 10);
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}

		int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int sum = 0;
				for(int k = 0; k < 4; k++) {
					int posI = i + dxy[k][0];
					int posJ = j + dxy[k][1];
					if( posI >= 0 && posI < 5 &&  posJ >= 0 && posJ < 5) {
						sum += Math.abs( arr[i][j] - arr[posI][posJ] );
					}
				}
				System.out.printf("%3d", sum);
			}
			System.out.println();
		}

	}
}
