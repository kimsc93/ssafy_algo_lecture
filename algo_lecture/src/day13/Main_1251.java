package algo_day_13;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_1251 {
	static int[] parents;
	static int[] rank;
	static class edges{
		int start,end;
		double cost;
		public edges(int start, int end, double cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

	}
	public static double cal(int x1, int x2,int y1,int y2) {
		return Math.pow(x1-x2,2)+Math.pow(y1-y2,2);
	}
	public static void main(String[] args) {
		InputStream input = Main_1251.class.getResourceAsStream("input1251.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		List<edges> list = new LinkedList<>();
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int V = sc.nextInt();
			int[][] island = new int[V][2];
			for (int i = 0; i < 2; i++) {
                for (int j = 0; j < V; j++) {
                	island[j][i] = sc.nextInt(); // 섬들의 좌표 받기
                }
            }
			double E = sc.nextDouble();
			for(int i=0;i<V;i++) {
				for(int j=i+1;j<V;j++) {
					double d = cal(island[i][0],island[j][0],island[j][0],island[j][0]);
					list.add(new edges(i,j,d));
				}
			}
			parents = new int[V];
			rank = new int[V];
			for(int i = 0; i < V; i++)	//노드초기화
				make_set(i);
			
			Collections.sort(list, new Comparator<edges>() {				
				public int compare(edges e1,edges e2) {
					return (int)e1.cost-(int)e2.cost;
				}
			});
			long result = 0;
			int cnt = 0;
			for(int i = 0; i < list.size(); i++) {
				if(cnt==V-1) break;
				edges ed = list.get(i);
				//간선배열정보를 탐색하면서, 시작-끝 정점이 속한 집합을 얻어와서
				int a = findSet(ed.start);
				int b = findSet(ed.start);
				//서로 다른 집합(아직 연결되지 않은 정점) 이라면
				if( a!= b) {
					//union
					union(a, b);
					//가중치 누적
					result += ed.cost;
					cnt++;	
				}
			}
			System.out.println("#" + tc + " " + Math.round(result * E));
		}				
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
