package algo_day_14;

import java.io.InputStream;
import java.util.Scanner;

public class Main_1861 {
	public static void main(String[] args) {
		InputStream input = Main_1861.class.getResourceAsStream("input1861.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(map, i, j, 1, map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + ansStart + " " + ansLen);
			ansLen = 0;
			ansStart = 987645321;
		}
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ansLen = 0;
	static int ansStart = 987645321;
	

	static void dfs(int[][] map, int r, int c, int cnt, int start) {
		
		if (ansLen <= cnt) {
			ansLen = cnt;
			if (ansLen == cnt) {
				ansStart = Math.min(ansStart, start);
			} else {
				ansStart = start;
			}
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if ( inArray(map.length, nr, nc) && map[nr][nc] == map[r][c] + 1) {
				dfs(map, nr, nc, cnt + 1, start);
			}
		}
	}
	
	public static boolean inArray(int N, int i, int j) {
		if (N - 1 >= i && i >= 0 && N - 1 >= j && j >= 0)
			return true;
		else
			return false;
	}
}
