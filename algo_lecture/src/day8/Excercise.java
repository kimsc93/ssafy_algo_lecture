package algo_day4_2;

import java.io.InputStream;
import java.util.Scanner;

public class Excercise {
	public static void main(String[] args) {
		InputStream is = Excercise.class.getResourceAsStream("input.txt");
		System.setIn(is);	
		Scanner sc = new Scanner(System.in);	
		int num= sc.nextInt();		
		
		Node[] node = new Node[num+1];
		for(int i=1;i<=13;i++) node[i] = new Node(i,null,null);	
		
		for(int i=1;i<=12;i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			if(node[parent].left==null) {
				node[parent].left = node[child];
			}
			else if(node[parent].right==null) {
				node[parent].right = node[child];
			}						
		}
		preOrder(node[1]);
		System.out.println();
		System.out.println(height(node[1]));
		System.out.println(size(node[1]));
	}
	static void preOrder(Node n) {
		if(n==null) return;		
		System.out.print(n.data+" ");
		preOrder(n.left);
		preOrder(n.right);
	}	
	static public int height(Node n) {
		if(n==null) 
			return 0;
		else 
			return Math.max(height(n.left), height(n.left))+1 ;  //왼쪽과 오른쪽 중에 큰놈+1;		
	}
	static public int size(Node n) {
		if(n==null) return 0;
		else return size(n.left)+size(n.right)+1;
	}
}
