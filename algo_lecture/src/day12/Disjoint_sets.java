package algo_day_12;

import java.util.Arrays;

public class Disjoint_sets {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		parents = new int[6];
		rank = new int[6];
		//0번 원소에 대해 make_set하면 자기 자신을 대표자로 삼아서 집합이 생성됨
		//1번 원소에 대해 make_set하면 자기 자신을 대표자로 삼아서 집합이 생성됨
		for(int i=0;i<parents.length;i++) {
			make_set(i);
		}
		parents[3] = 2;
		parents[4] = 2;
		parents[5] = 4;
		System.out.println(find_set(5));
		union(2,3);
		union(4,5);
		union(3,5);
		System.out.println(Arrays.toString(parents));
	}
	static void make_set(int x) {
		parents[x]=x;
	}
	static int find_set(int x) {	//5의 부모는 4,4의 부모는 2,5의 findSet이 2가 나오도록
		if(x==parents[x]) {			
			return parents[x];
		}
		else {
			parents[x] =find_set(parents[x]);
			return parents[x];
		}		
	}
	static void union(int x,int y) {
		//x와 y의 대표자를 찾아서
		//각 두 대표자 중 한개를 대표자로 지정
		//rank가 같은 경우 대표자가 되는 놈의 rank++
		int rep1 = find_set(x);
		int rep2 = find_set(y);
//		if(rep1!=rep2) {
//			parents[rep2] = rep1;
//		}
		if(rank[rep1]>rank[rep2]) {
			parents[rep2] = rep1;
		}
		else {
			parents[rep1] = rep2;
			if(rank[rep1]==rank[rep2]) {
				rank[rep2]++;
			}
		}
	}
}
