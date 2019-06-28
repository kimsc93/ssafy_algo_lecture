package day02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class quater4by4 {
	static Set<String> set = new HashSet<>();
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int[][] arr = new int[4][4];
		for(int tc=1;tc<=T;tc++) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					arr[i][j]=sc.nextInt();					
				}				
			}			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					recur(arr,i,j,0,7,"");													
				}
			}
			System.out.println("#"+tc+" "+set.size());
			ans=0;
			set=null;
			set = new HashSet<>();	
		}
	}
	//사방탐색
	public static void recur(int[][] arr,int y,int x,int n,int depth,String str) {
		if(n==depth) {
			set.add(str);
			return;
		}		
		str+=Integer.toString(arr[y][x]);
		if(y-1>=0) {	//위
			recur(arr,y-1,x,n+1,depth,str);
		}
		if(y+1<4) {	//아래
			recur(arr,y+1,x,n+1,depth,str);
		}
		if(x-1>=0) {	//좌
			recur(arr,y,x-1,n+1,depth,str);
		}
		if(x+1<4) {	//우
			recur(arr,y,x+1,n+1,depth,str);
		}
		str = str.substring(0, str.length()-1);
//		for(int i=y;i<4;i++) {
//			for(int j=x;j<4;j++) {
//				if(i-1>=0) {	//위
//					recur(arr,i-1,j,n+1,depth);
//				}
//				if(i+1<4) {	//아래
//					recur(arr,i+1,j,n+1,depth);
//				}
//				if(j-1>=0) {	//좌
//					recur(arr,i,j-1,n+1,depth);
//				}
//				if(j+1<4) {	//우
//					recur(arr,i,j+1,n+1,depth);
//				}
//			}				
//		}
	}
}
