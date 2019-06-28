package algo_day4_2;

import java.util.Arrays;
import java.util.Scanner;

public class gyuyeongAndInyeong {
	
	static int[] g_cards = new int[9];
	static int[] i_cards = new int[9];
	static int g_win = 0;
	static int fact9 = 9*8*7*6*5*4*3*2;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			boolean[] check = new boolean[19];
			int i_cnt=0;
			for(int  i=0;i<9;i++) {
				g_cards[i] = sc.nextInt();
				check[g_cards[i]]=true;
			}
			for(int i=1;i<=18;i++) {
				if(check[i]==false) {
					i_cards[i_cnt++] = i; 
				}
			}
			
			perm(i_cards,0);
			System.out.println("#"+tc+" "+g_win+" "+(fact9-g_win));
			g_win = 0;
		}
	}
	public static void perm(int[] arr,int n) {
		if(n==arr.length) {
			int g_sum=0;
			int i_sum=0;
			for(int i=0;i<9;i++) {
				if(g_cards[i]>arr[i]) {
					g_sum += g_cards[i]+arr[i];
				}
				else {
					i_sum += g_cards[i]+arr[i];
				}
			}			
			if(g_sum>i_sum) {
				g_win++;
			}
			return;
		}
		
		for(int i=n;i<arr.length;i++) {
			swap(arr,n,i);
			perm(arr,n+1);
			swap(arr,n,i);
		}		
	}
	public static void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
