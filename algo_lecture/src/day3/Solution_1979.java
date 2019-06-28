package com.ssafy;

import java.util.Scanner;
 
public class Solution_1979 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int result=0;//정답이 저장될 변수
            for(int i=0;i<N;i++) { //행 탐색하면서
                int count =0; //해당 행에서의 연속된 빈칸을 세기 위한 변수.
                for(int j=0;j<N;j++) {
                    if(arr[i][j] == 1) //빈칸을 만나면 
                        count++;   // 숫자 세고
                    else {
                        count=0; // 빈칸이 아닌걸 만나는순간 도로묵
                    }
                     
                    if(count == K && j +1 < N && arr[i][j+1] == 0) //갯수를 달성하면 정답 ++
                    {
                        result++;
                    }
//                    if(count == K+1) { //된줄알았는데 아니면 물려.ㅠ
//                        count=0;
//                        result--;
//                    }
                }
                 
            }
            for(int j=0;j<N;j++) {
                int count =0;
                for(int i=0;i<N;i++) {
                    if(arr[i][j] == 1)
                        count++;
                    else {
                        count=0;
                    }
                     
                    if(count == K)
                    {
                        result++;
                    }
                    if(count == K+1) {
                        count=0;
                        result--;
                    }
                }
                 
            }
            System.out.println("#"+test+" "+result);
        }
    }
 
}