package algo_day_15;

import java.util.Scanner;

//백준
public class Main_11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("4 3\r\n" + 
				"1 2 3\r\n" + 
				"6 5 4\r\n" + 
				"7 8 9\r\n" + 
				"12 11 10");
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j] = sc.nextInt();
				if(i==N&&j==M) {
					goback(map,i,j,map[i][j]);
				}
			}
		}

	}
	public static void goback(int[][] map , int i ,int j,int sum) {
		if(i==1&&j==1) {
			System.out.println(sum);
			return ;
		}
		if(map[i-1][j]>=map[i][j-1] ) {
			if(map[i-1][j] >= map[i-1][j-1]) {
				goback(map,i-1,j,sum+map[i-1][j] );
			}else {
				goback(map,i-1,j-1,sum+map[i-1][j-1] );
			}
		}
		else {
			if(map[i][j-1] >= map[i-1][j-1]) {
				goback(map,i,j-1,sum+map[i][j-1] );
			}else {
				goback(map,i-1,j-1,sum+map[i-1][j-1] );
			}
		}
	}

}
