package algo_day_13;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
//정올 1863 종교 : 과제
public class Main_1494 {
    public static void main(String[] args) {
    	InputStream input = Main_1494.class.getResourceAsStream("input1494.txt");
		System.setIn(input);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();// 2 ≤ N ≤ 20, N은 짝수
            int[][] pos = new int[N][2];
            for (int i = 0; i < N; i++) {
                pos[i][0] = sc.nextInt();
                pos[i][1] = sc.nextInt();
            }
            min = 987654321987654321L;
            powerSet(pos, new boolean[N], 0, N, 0);
            System.out.println("#" + tc + " " + min);
        }
    }
    
    static long min = 987654321987654321L;
    
    static void powerSet(int[][] pos, boolean[] selected, int idx, int N, int tCnt) {
        if (idx == N) {
            if (tCnt == N / 2) {
                // doSomething
                // 이동하는 지렁이는 +
                // 가만있는 지렁이는 -
                int totalX = 0;
                int totalY = 0;
                for (int i = 0; i < N; i++) {
                    if (selected[i]) {
                        totalX += pos[i][0];
                        totalY += pos[i][1];
                    } else {
                        totalX -= pos[i][0];
                        totalY -= pos[i][1];
                    }
                }
                long tmp = totalX * (long) totalX + totalY * (long) totalY;
                if (min > tmp)
                    min = tmp;
//              System.out.println(Arrays.toString(selected) + " " + totalX + " " + totalY);
            }
            return;
        }
        selected[idx] = true;
        powerSet(pos, selected, idx + 1, N, tCnt + 1);
        selected[idx] = false;
        powerSet(pos, selected, idx + 1, N, tCnt);
    }
}