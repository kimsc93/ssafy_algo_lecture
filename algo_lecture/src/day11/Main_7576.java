package algo_day_11;

import java.util.LinkedList;
import java.util.Scanner;

import algo_day_11.Main_2178.Status;

public class Main_7576 {
	//backjun.com 7576
	static int min=987654321;
	static int[] delr = {-1,1,0,0};
	static int[] delc = {0,0,-1,1};	
	static class Status {
		int r, c,cnt;
		Status(int r, int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int count=0;
	public static void main(String[] args) {
		String input = "2 2\r\n" + 
				"1 -1\r\n" + 
				"-1 1";
		Scanner sc = new Scanner(input);
		int col = sc.nextInt();
		int row = sc.nextInt();		
		int[][] arr= new int[row][col];
		int curR=0;
		int curC=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j] = sc.nextInt();
			}
		}		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j]==1) {
					curR=i;
					curC=j;
				}
			}
		}	
		bfs(arr,curR,curC);
		if(!hasNotZero(arr)) {
			min = -1;
		}
		System.out.println(min);
	}
	static void bfs(int[][] map,int curR,int curC) {
		LinkedList<Status> list = new LinkedList<>();
		list.add(new Status(curR,curC,1));
		while(!list.isEmpty()) {
			Status status = list.poll();			
			for(int i=0;i<delr.length;i++) {
				int nr = status.r+delr[i];
				int nc = status.c+delc[i];
				if(nr <0 || nr>=map.length || nc<0 || nc>=map[0].length) {
					continue;
				}
				if(map[nr][nc]==0) {					
					list.add(new Status(nr,nc,status.cnt+1));
					map[nr][nc]=1;
				}
			}
			if(hasNotZero(map)) {
				min = status.cnt;
				return;
			}
			else {
				min=-1;
			}
		}	
	}
	static boolean hasNotZero(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==0) return false;
			}
		}
		return true;
	}
}
