package algo_day_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//하나로 문제
public class Solution_hanaro_taeyong {
	static int[] parents;
	static int[] rank;

	static class Struct implements Comparable<Struct> {
		int A;// 노드 1
		int B;// 노드 2
		long dis; // 간선 길이

		Struct(int A, int B, long dis) {
			this.A = A;
			this.B = B;
			this.dis = dis;
		}
		
		@Override
		public String toString() {
			return "[A=" + A + ", B=" + B + ", dis=" + dis + "]";
		}

		@Override
		public int compareTo(Struct o) {
			// TODO Auto-generated method stub
			return Long.compare(this.dis, o.dis);
		}
	}	
	
	public static void main(String[] args) throws IOException {

		// System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());// 테스트 케이스 갯수

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 노드 갯수
			double pointer[][] = new double[N][2]; // 노드가 가지고 있는 X[0], Y[1]

			parents = new int[N]; // 각 노드의 부모 노드를 저장하는 배열
			rank = new int[N]; // 그 노드가 가지고 있는 자식노드의 갯수

			// 노드 초기화
			for (int i = 0; i < N; i++) {
				make_set(i); // 자기 자신을 부모노드로 초기화
			}

			// 각 노드에 포인터를 받을
			for (int i = 0; i < 2; i++) { // x or y
				// X: 0, 1, 2, 3
				// Y: 0,1,2,3
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pointer[j][i] = Double.parseDouble(st.nextToken());
				}
			}
			// 환경부담 세율 주어지는 상수
			double E = Double.parseDouble(br.readLine());
			//우선순위 Queue를 사용해도 되고
			//Queue를 사용해서 다 받은다음 나중에 소트 (MY)
			Queue<Struct> pq = new LinkedList<>();
			for (int i = 0; i < N; i++) {// 0 to N
				for (int j = i + 1; j < N; j++) { // i to N
					//간선을 전부 개산해서 넣기 
					//길이의 식을 (x1 - x2)^2 + (y1 - y2)^2
					long weight = (long) (Math.pow(pointer[i][0] - pointer[j][0], 2)
							+ Math.pow(pointer[i][1] - pointer[j][1], 2));
					
					//queue에 추가
					pq.add(new Struct(i, j, weight));

				}
			}
			//queue를 정렬 
			Collections.sort((List<Struct>) pq);
			int count = 0; // 추가 되는 간선의 갯수
			long answer = 0; // 정답 출력 변수
			while (!pq.isEmpty()) { // queue에 있는 모든 간선을 전부다 넣어보고, 전부 확인했으면 끝
				Struct st = pq.poll();//queue에서 하나씩 빼서 
				if (findSet(st.A) != findSet(st.B)) { // 같은 부모 노드를 가지고 있지 않을때 == 순환 되지 않을때
					count++; // 간선 갯수 추가
					answer += st.dis; // 간선 길이를 정답변수에 추가
					union(st.A, st.B); // 간선을 잇는다.
				}
			}
			answer = Math.round(answer * E);	// round  소수자리 제거
			System.out.println("#" + test_case + " " + answer);
		}
	}
	// 노드 초기화 함수
	static void make_set(int x) {

		parents[x] = x; // 자기자신이 부모
		rank[x] = 0; // 자식노드가 없는 rank 0
	}
	// 부모를 찾는 함수
	static int findSet(int x) {
		if (x == parents[x]) // 자기 자신이 부모인경우
			return x;
		else {
			parents[x] = findSet(parents[x]); // 자신의 부모를 찾을때까지 재귀를 반복
			return parents[x]; // 재귀가 끝나고 부모노드를 찾게 되면 리턴
		}
	}
	// 노드두개를 합치는 함수
	// x노드, y노드를 받아서 합친다.
	static void union(int x, int y) {
		// 각 노드의 부모 노드를 찾고
		int px = findSet(x);
		int py = findSet(y);
		// 노드를 합칠때 고려해야 할 사항
		// 합칠 두개의 노드에 자식 노드 갯수를 비교해서
		// 자식 노드의 갯수가 더 큰 노드로 합치기
		if (rank[px] > rank[py]) {
			parents[py] = px; // py의 부모 노드를 px로 수정
		} else {
			parents[px] = py; // px의 부모노드를 py로 수정

			if (rank[px] == rank[py]) {
				rank[py]++; // py의 랭크를 증가
			}
		}
	}
}
