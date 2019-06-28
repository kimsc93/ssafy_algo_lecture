package algo_day_15;

public class Matrix_move {
	public static void main(String[] args) {
		int[][] map = { { 0, 0, 0, 0, 0 }, 
						{ 0, 13, 7, 16, 6 }, 
						{ 0, 14, 2, 15, 10 }, 
						{ 0, 1, 5, 3, 8 },
						{ 0, 11, 4, 9, 12 } };
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (map[i][j - 1] >= map[i - 1][j]) {
					map[i][j] += map[i][j - 1];
				} else {
					map[i][j] += map[i - 1][j];
				}
			}
		}
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
				if (i == map.length - 1 && j == map[0].length - 1) {
					System.out.println();
					back(map, i, j);
				}
			}
			System.out.println();
		}
	}
	static void back(int[][] map, int i, int j) {
		if (i == 1 && j == 1) {
			System.out.println(map[i][j]);
			return;
		}
		if (map[i - 1][j] >= map[i][j - 1]) {
			System.out.print(map[i][j] + " >> ");
			back(map, i - 1, j);
		} else {
			System.out.print(map[i][j] + " >> ");
			back(map, i, j - 1);
		}
	}
}
