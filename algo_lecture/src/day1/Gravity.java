package com.ssafy.algo;

import java.util.Scanner;

public class Gravity {
	public static void main(String[] args) {
//		7 4 2 0 0 6 0 7 0
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] map = new int[N][N];
		//각 열을 순회하면서
		for(int j = 0; j < N; j++) {
			//열의 높이를 그때그때 입력받아서
			int h = sc.nextInt();
			//행의 맨 바닥부터 입력받은 열의 높이만큼 1을 채움. 
			for(int i = N-1; i >=0; i--) {
				if(h == 0)
					break;
				map[i][j] = 1;
				h--;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = N-1; j >=0; j--)
				System.out.print(map[j][i]);
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int[] arr = new int[N];
//		for(int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		//최대치를 기억하기 위한 변수. 
//		int max = 0; 
//		
//		//각 막대들이 가질 수 있는 최대 낙차 N - ( i + 1 )
//		for(int i = 0; i < N; i++) {
////			System.out.println((i+1)+"번째 막대가 가질 수 있는 최대낙차 : " + ( N - ( i + 1 )) );
//			int cnt = (N - ( i+1 ));
//			//내 오른쪽으로 있는 막대들 중에
//			//나와 키가 같거나 나보다 키가 큰 막대의 수 만큼 최대낙차 차감
//			//(왜냐면 내 밑에 깔려서 내 낙차를 줄여줄거니까)
//			for(int j = i + 1; j < N; j++) {
//				if( arr[j] >= arr[i] )
//					cnt--;
//			}
////			System.out.println((i+1)+"번째 막대의 최대낙차 : " + cnt);
//			//각 막대의 최대낙차가 구해질 때마다 지금까지 구해진 최대값과 비교하여 갱신. 
//			if( max < cnt )
//				max = cnt;
//			
//		}
//		System.out.println(max);
	}
}
