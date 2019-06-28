
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Solution21 {
	static long Answer;
	static int N, S;
	static int[] arrX = { 0, 1, 0 };
	static int[] arrY = { 0, 0, 1 };

	public static boolean Range(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		InputStream input = Solution21.class.getResourceAsStream("Solution21.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt(); // 연못크기
			int[][] lake = new int[N][N];

			S = sc.nextInt(); // 소금쟁이 수
			int[][] strider = new int[S][3];
			for (int k = 0; k < S; k++) {
				strider[k][0] = sc.nextInt(); // 행
				strider[k][1] = sc.nextInt(); // 열
				strider[k][2] = sc.nextInt(); // 방향
			}

//			for (int k = 0; k < S; k++) { // 처음 소금쟁이 배치
//				lake[strider[k][0]][strider[k][1]] = 1;
//			}

			for (int i = 0; i < S; i++) {
				int nowx = strider[i][0];
				int nowy = strider[i][1];
				int dir = strider[i][2];
				int nx = -1, ny = -1;

				for (int j = 3; j >= 1; j--) {
					nx = nowx + arrX[dir] * j;
					ny = nowy + arrY[dir] * j;

					if (Range(nx, ny)) // 경계나간경우
						break;

					if (lake[nx][ny] == 1) { // 2번마주친경우
						Answer = i + 1;
						break;
					}

					lake[nx][ny] = 1;
					nowx = nx;
					nowy = ny;
				}

				if (Answer != 0)
					break;
			}

			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
