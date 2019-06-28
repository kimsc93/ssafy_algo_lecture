package algo_day_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdjList {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input.txt"));	//표준입력 키보드대신
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			//인접리스트 표현
			//정점의 갯수만큼 LinkedList생성		
			List<Node>[] list = new LinkedList[V];
			for(int i=0;i<V;i++) {
				list[i] = new LinkedList<Node>();
			}
			for (int i = 0; i < E; i++) {
				int curI = sc.nextInt();
				int curJ = sc.nextInt();
				int value = sc.nextInt();
				list[curI].add(new Node(curJ,value));	//각각 연결됨을 표현
				list[curJ].add(new Node(curI,value));	//가중치까지 하려면 객체로저장

			}
			for(int i=0;i<V;i++) {
				System.out.println(list[i]);
			}
		}			
	}
	static class Node{
		int dest;
		int cost;
		public Node(int d,int c) {
			dest=d; cost=c;
		}
		public String toString() {
			return dest+" "+cost;
		}
	}
}
