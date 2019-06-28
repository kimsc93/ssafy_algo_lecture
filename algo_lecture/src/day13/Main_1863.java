package algo_day_13;

import java.io.InputStream;
import java.util.Scanner;

//정올 1863종교
public class Main_1863 {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) {;
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] edges = new int[E][2];		
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
		}
		parents = new int[V];
		rank = new int[V];		
		for(int i = 0; i < V; i++)
			make_set(i);
		int cnt = 0;
		for(int i = 0; i < E; i++) {
//			if(cnt == V-1)
//				break;
			//간선배열정보를 탐색하면서, 시작-끝 정점이 속한 집합을 얻어와서
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			//서로 다른 집합(아직 연결되지 않은 정점) 이라면
			if( a!= b) {
				//union
				union(a, b);
				cnt++;
			}
		}		
//		for(int i=0;i<rank.length;i++) {
//			System.out.print(rank[i]+" ");
//		}
//		System.out.println();
//		
		int result=0;
		for(int i=0;i<parents.length;i++) {
			if(i==parents[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	static void make_set(int x) {
		parents[x] = x;
		rank[x] = 0;
	}
	
	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
