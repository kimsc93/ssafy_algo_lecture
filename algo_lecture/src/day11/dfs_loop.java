package algo_day_11;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class dfs_loop {
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
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V+1];
		stack.push(1);
		while(!stack.isEmpty()) {
			int v = stack.pop();			
			if(!visited[v]) {
				System.out.println(v);
				visited[v]=true;
				for(int i=1;i<adj.length;i++) {
					if(!visited[i] && adj[v][i]==1) {
						stack.push(i);
					}
				}
			}
		}		
	}
}
