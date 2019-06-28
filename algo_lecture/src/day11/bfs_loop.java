package algo_day_11;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bfs_loop {	
//	큐를만든다.
//	방문체크배열을 만든다.
//	하나의 정점을 큐에 넣는다
//	그 정점의 체크배열에 체크
//	while큐가 비지 않으면
//		큐에서 꺼내서 방문(출력)
//		인접 중 안방문 정점 큐에 삽입
//		큐에 삽입한 정점 방문배열에 체크
	public static void main(String[] args) throws FileNotFoundException {		
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
		LinkedList<Integer> list = new LinkedList<>();
		boolean[] visited= new boolean[V+1];
		list.offer(1);
		visited[1] = true;
		while(!list.isEmpty()) {
			int v = list.poll();
			System.out.println(v);
			for(int i=0;i<adj.length;i++) {
				if(!visited[i] && adj[v][i]==1) {
					list.add(i);
					visited[i] = true;
				}
			}
		}		
	}
}
