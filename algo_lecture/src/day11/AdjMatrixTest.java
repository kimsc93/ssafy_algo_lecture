package algo_day_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/input.txt"));	//표준입력 키보드대신
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			//정점의 수만큼 행과 열을 갖는 2차원배열 준비
			//입력되는 간선의 정보를 준비한 인접행렬의 적절한 위치에 기록
			//무향 그래프
			int[][] arr = new int[V][V];
			
			for (int i = 0; i < E; i++) {
				int curI = sc.nextInt();
				int curJ = sc.nextInt();
				int value = sc.nextInt();
				arr[curI][curJ] = value;
				arr[curJ][curI] = value;
			}
			for(int i=0;i<arr.length;i++) {
				System.out.println(Arrays.toString(arr[i]));
			}			
		}		
	}
}
