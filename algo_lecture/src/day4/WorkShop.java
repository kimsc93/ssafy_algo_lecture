package algo_day4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkShop {

	static int[][] map = new int[100][100];
	static int[] lanes = new int[100];
	static int result;

	static int[] goX = { 0, 0, 1, -1 };
	static int[] goY = { -1, 1, 0, 0 };// 북남동서

	public static void solve() {
		int start = 0;
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			if (map[99][i] == 2) {
				
				start = i;
			}
			else if(map[99][i] == 1 ) {
				lanes[cnt++] = i;
			}
		}

		int floor = 99;
		int current = start;

		while (floor > 0) {
			System.out.println(floor + " " + start + " " + map[floor][start]);
			if (start != 0 && map[floor][start - 1] == 1)// left
			{
				while (map[floor][start - 1] != 0) {
					start--;
					if (start == 0)
						break;

					if (map[floor][start - 1] == 0)
						break;
				}
			} else if (start != 99 && map[floor][start + 1] == 1)// right
			{
				while (map[floor][start + 1] != 0) {
					start++;
					if (start == 99)
						break;

					if (map[floor][start + 1] == 0)
						break;

				}
			}
			
			floor--;
		
		}

		result = start;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			result = 0;
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < map.length; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}

			}

			solve();

			/*
			 * for (int i = 0; i < map.length; i++) { for (int j = 0; j < map.length; j++)
			 * System.out.print(map[i][j]); System.out.println(); } System.out.println();
			 */

			System.out.println("#" + (num) + " " + result);

		}
	}

}
