package algo_day_13;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1258 {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		InputStream input = Main_1258.class.getResourceAsStream("input1258.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			/// 입력
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[] submat_i = new int[20];
			int[] submat_j = new int[20];
			int[] submat_width = new int[20];
			int matrixCnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int searchPointI = 0;
			int searchPointJ = 0;
			int startI = 0; // 처음 만난 행렬 왼쪽 위부분 저장
			int startJ = 0;
			int endI = 0; // 처음 만난 행렬 오른쪽 아래부분 저장
			int endJ = 0;
			outer1: while (true) {
				outer2: for (int i = searchPointI; i < N; i++) {
					for (int j = searchPointJ; j < N; j++) {
						if (i == N - 1 && j == N - 1) { // 탐색을 배열 마지막점까지 오면 완전종료
							break outer1;
						}
						if (arr[i][j] != 0) { // 0이 아닌 시작점 발견시
							startI = i;
							startJ = j;
							break outer2;
						}
					}
					searchPointJ = 0;
				}
				// 처음만난 부분에서부터 옆으로가서 행렬 마지막부분검색
				for (int j = startJ; j < N; j++) {
					if (arr[startI][j] == 0) {
						endJ = j - 1;
						break;
					}
					if (j + 1 == N) {
						endJ = j;
						break;
					}
				}
				// 처음만난 부분에서부터 아래로가서 행렬 마지막부분검색
				for (int i = startI; i < N; i++) {
					if (arr[i][startJ] == 0) {
						endI = i - 1;
						break;
					}
					if (i + 1 == N) {
						endI = i;
						break;
					}
				}
				// 찾은 행렬정보 저장
				int i_len = endI - startI + 1;
				int j_len = endJ - startJ + 1;
				submat_i[matrixCnt] = i_len;
				submat_j[matrixCnt] = j_len;
				submat_width[matrixCnt] = i_len * j_len;
				matrixCnt++;
//				 찾은 행렬부분을 지워버림(0으로)
				for (int i = startI; i <= endI; i++) {
					for (int j = startJ; j <= endJ; j++) {
						arr[i][j] = 0;
					}
				}
				searchPointI = startI; // 좀전에 찾은 행렬의 시작점을 다시 탐색시작점으로
				searchPointJ = startJ;
			} // while문 종료
			
			for (int i = 0; i < matrixCnt - 1; i++) { // 행렬정보 너비 작은거 순 정렬
				for (int j = i + 1; j < matrixCnt; j++) {
					if (submat_width[i] > submat_width[j]) {
						swap(submat_i, i, j);
						swap(submat_j, i, j);
						swap(submat_width, i, j);
					}
				}
			}
			System.out.print("#" + tc + " " + matrixCnt + " "); // 행렬정보 출력
			for (int i = 0; i < matrixCnt; i++) {
				System.out.print(submat_i[i] + " " + submat_j[i] + " ");
			}
			System.out.println();
		}
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
