package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int[][] map = new int[1000][1000];
    static int[] rows = new int[1000];
    static int[] cols = new int[1000];
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
             
            for (int i = 0; i < N; i++) {
                rows[i] = 0;
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = (line.charAt(j));
                    rows[i]+=map[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                cols[i] = 0;
                for (int j = 0; j < N; j++) {
                    cols[i] += map[j][i];
                }
            }
            int ans = 0;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = rows[i];
                    cnt += cols[j];
                    if( map[i][j] == 1)
                        cnt++;
                     
                    if (cnt % 2 == 1)
                        ans++;
                }
 
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
 
}