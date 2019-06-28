package algo_day_12;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner("6 11\r\n" + 
				"0 1 3\r\n" + 
				"0 2 5\r\n" + 
				"1 2 2\r\n" + 
				"1 3 6\r\n" + 
				"2 1 1\r\n" + 
				"2 4 6\r\n" + 
				"2 3 4\r\n" + 
				"3 4 2\r\n" + 
				"3 5 3\r\n" + 
				"4 0 3\r\n" + 
				"4 5 6");
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for(int i = 0; i < E; i++)
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		//0번 정점부터 출발할거니깐, 0번 정점까지의 거리는 0이고, 다른 정점까지의 알려진 거리는
		//0번부터 경로가 있는 경우 그 경로비용, 경로가 없는 경우 무한대
		for(int i=1;i<V;i++) {
			dist[i] = adj[0][i];
			if(adj[0][i]==0) {
				dist[i] = 987654321;
			}
		}
		visited[0] = true;
		//하나는 이미 방문했으니, 나머지 정점의 갯수만큼 최단거리를 구하자
		for(int i=0;i<V-1;i++) {
			int min=0;
			int minVal = 987645312;
			for(int j=0;j<V;j++) {
				if(!visited[j] && minVal > dist[j]) {
					min=j;
					minVal = dist[j];
				}
			}
			//고른놈 선택으로 바꾸고
			//고른놈으로부터 갈수있는 곳 중에서 기존 알고있던 dist보다 빨리 갈수 있는곳
			for(int j=0;j<V;j++) {
				//고른 놈으로부터 길이 있으면서
				if(adj[min][j]!=0 && dist[j] > dist[min] +adj[min][j]) {
					dist[j] = dist[min]+adj[min][j];
				}
			}
			visited[min] = true;
			System.out.println(Arrays.toString(dist));
		}
		System.out.println(Arrays.toString(dist));
		
	}
}










