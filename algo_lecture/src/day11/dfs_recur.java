package algo_day_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class dfs_recur {
	public static void main(String[] args) throws FileNotFoundException {
		
//		System.setIn(new FileInputStream("res/input.txt"));	//표준입력 키보드대신
		Scanner sc = new Scanner("7 8\r\n"+
		"1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V+1][V+1];//정점의 번호가 1번부터 7번
		for(int i=0;i<E;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		dfs(adj,new boolean[V+1],1,1);		
	}
	static void dfs(int[][] adj, boolean[] visited, int idx, int v) {	
		//간선의 정보, 정점의 개수, 정점별 방문여부, 현재 방문이 몇번째 인지, 이번에 방문할 정점넘버
		//현재 방문하는 정점에서 할일하고 visited체크
		System.out.println(v);
		visited[v]=true;
		if(idx==adj.length) {
			return;
		}
		//v와 연결된 정점 중 이미 방문하지 않은 정점을 방문(재귀 호출)
		for(int i=1;i<adj.length;i++) {
			//연결된 정점 > adj[v][i]==1
			//방문하지 않은 정점 > visited[i]==false
			if(adj[v][i]==1 && !visited[i]) {
				dfs(adj,visited,idx+1,i);
			}
		}
	}
}
