package algo_day_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\r\n" + 
				"0 1 32\r\n" + 
				"0 2 31\r\n" + 
				"0 6 51\r\n" + 
				"0 5 60\r\n" + 
				"1 2 21\r\n" + 
				"2 4 46\r\n" + 
				"2 6 25\r\n" + 
				"3 4 34\r\n" + 
				"4 6 51\r\n" + 
				"5 3 18\r\n" + 
				"5 4 40\r\n");
		//1. 위 입력을 인접행렬에 저장하세요
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for(int cnt=0;cnt<E;cnt++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			int value = sc.nextInt();
			adj[i][j] =value;
			adj[j][i] =value;
		}
		for(int i=0;i<adj.length;i++) {
			System.out.println(Arrays.toString(adj[i]));
		}
		int minCost=0;
		int index=0;	//새로연결되는 정점의 번호를 저장할 변수
		ArrayList<Integer> selectedList = new ArrayList<>();
		boolean[] selected = new boolean[V];
		//2.0번 노드를 첫번째 노드로 지정(선택체크 및 리스트에 담기)
		selected[0]=true;		
		selectedList.add(0);
		int result=0;
		for(int i=0;i<V-1;i++) {	//시작 정점을 뺀 나머지 정점 수 만큼 반복
			//방문했던 모든 정점을 순회하면서
			//인접노드이면서, 아직 선택되지 않으면서, 경로비용이 최소인 것을 찾기
			index=0;
			minCost = 987654321;
			
			//기준 정점 : 현재 선택된 정점들
			//기준 정점으로부터 연결된 모든 정점(이미 선택된 놈 제외)중에서 경로비용이 젤 작은 비용과 정점 선택
			for(int j: selectedList) {
				for(int k=0;k<V;k++) {
					//adj[j][k]가 0이면 연결안됨
					//selected[k]가 true이면 이미 한패
					if(!selected[k] && adj[j][k]!=0) {
						if(minCost>adj[j][k]) {
							minCost=adj[j][k];
							index=k;
						}
					}
				}	
			}
			result+=minCost;
			selectedList.add(index);
			selected[index]=true;
		}
		System.out.println(result);
	}
}
