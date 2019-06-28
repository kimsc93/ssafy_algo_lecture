package day01;

import java.util.Scanner;

public class Meeting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); //미팅의 갯수.
		int[][] meetingTable = new int[M][2];
		for(int i = 0; i < M; i++) {
			meetingTable[i][0] = sc.nextInt(); //시작
			meetingTable[i][1] = sc.nextInt(); //종료
		}
		for(int j = 0; j < M; j++) {
			int min = j;
			for(int i = j; i < M-1; i++) {
				if( meetingTable[i][1] < meetingTable[min][1])
					min = i;
			}
			int[] tmp = meetingTable[min];
			meetingTable[min] = meetingTable[j];
			meetingTable[j] = tmp;
		}
		int lastFinishTime = 0;
		int cnt = 0;
		for( int i = 0; i < M; i++) {
			if( lastFinishTime <= meetingTable[i][0] ) {
				cnt++;
				lastFinishTime = meetingTable[i][1];
			}
		}
		System.out.println(cnt);
	}
}





