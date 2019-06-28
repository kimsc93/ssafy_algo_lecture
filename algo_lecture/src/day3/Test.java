package com.ssafy;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int[][] map = new int[6][6];

		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			change(map, a, b);
			print(map);
		}

	}

	static void change(int[][] map, int a, int b) {
		for (int i = 0; i < 6; i++) {
			map[i][b]++;
			map[a][i]++;
		}
		map[a][b]--;
	}

	static void print(int[][] map) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j] % 2);
			}
			System.out.println();
		}
	}
}
