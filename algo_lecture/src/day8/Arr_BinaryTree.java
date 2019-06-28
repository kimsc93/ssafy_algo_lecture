package algo_day4_2;

import java.util.Arrays;

public class Arr_BinaryTree {
	private int[] tree;
	private int root =1;
	public Arr_BinaryTree (int max_level) {
		//max level에 맞게 배열 할당		
		tree = new int[1<<max_level];
	}
	public void setRoot(int data) {
		//parent인덱스에 위치한 노드의 왼쪽자식노드가 위치해야되는 인덱스에 data입력
		tree[root] = data; 
	}
	public void setLeft(int data,int parent) {
		//parent인덱스에 위치한 노드의 왼쪽자식노드가 위치해야되는 인덱스에 data입력
		tree[parent*2] = data;
	}
	public void setRight(int data,int parent) {
		//parent인덱스에 위치한 노드의 오른쪽자식노드가 위치해야되는 인덱스에 data입력
		tree[parent*2+1] = data;
	}
	public int getLeft(int node) {
		//node 인덱스에 위치한 노드의 왼쪽 노드값 리턴	
		return tree[node*2];
	}
	public int getRight(int node) {
		//node 인덱스에 위치한 노드의 오른쪽 노드값 리턴	
		return tree[node*2+1];
	}
	public String toString() {
		return Arrays.toString(tree);
	}
	void preorder_traverse(int root) {
		if(tree[root]!=0) {
			System.out.print(tree[root]+" ");
			preorder_traverse(2*root);
			preorder_traverse(2*root+1);			
		}				
	}
	void Inorder_traverse(int root) {
		if(tree[root]!=0) {
			Inorder_traverse(2*root);
			System.out.print(tree[root]+" ");
			Inorder_traverse(2*root+1);			
		}				
	}
	void postorder_traverse(int root) {
		if(tree[root]!=0) {
			postorder_traverse(2*root);
			postorder_traverse(2*root+1);
			System.out.print(tree[root]+" ");
		}				
	}
	
	public static void main(String[] args) {
		Arr_BinaryTree bt = new Arr_BinaryTree(5);
		bt.setRoot(10);
		bt.setLeft(20, 1);
		bt.setRight(30,1);
		bt.setLeft(40, 3);
		bt.setRight(50, 3);
		System.out.println(bt.toString());
		bt.preorder_traverse(1);
		System.out.println();
		bt.Inorder_traverse(1);
		System.out.println();
		bt.postorder_traverse(1);
	}
}
