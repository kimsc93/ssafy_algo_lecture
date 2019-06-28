package algo_day_14;

import java.io.InputStream;
import java.util.Scanner;

public class Main_1861_2 {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		InputStream input = Main_1861.class.getResourceAsStream("input1861.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N + 2][N + 2]; // 상하좌우 가장자리 비워두자
			// 1번행부터 N+1버 행까지 1번열부터 N+1열까지 공간에 입력

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
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
	
	// 필요한 정보 map, 현재 위치, 카운트, 시작점
	static void dfs(int[][] map, int r, int c, int cnt, int start) {
		if (ansLen <= cnt) {
			ansLen = cnt;
			if (ansLen == cnt) {
				ansStart = Math.min(ansStart, start);
			} else {
				ansStart = start;
			}
		}
		// 4가지 방향으로 이동가능한 곳이라면 재귀호출
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (map[nr][nc] == map[r][c] + 1) {
				dfs(map, nr, nc, cnt + 1, start);
			}
		}
	}

}
