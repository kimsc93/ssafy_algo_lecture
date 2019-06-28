package algo_day4_2;

public class BinaryTree {
	private Node root;
	public void setRoot(Node r) {
		root = r;
	}
	public Node getRoot() {
		return root;
	}
	public void addLeft(Node parent, Node child) {
		parent.left = child;		
	}
	public void addRight(Node parent, Node child) {
		parent.right = child;		
	}
	public boolean isEmpty() {
		return root==null;
	}
	public void preorder(Node n) {
		if(n!=null) {
			System.out.println(n.data+" ");
			preorder(n.left);
			preorder(n.right);
		}
	}
	public int height(Node n) {
		if(n==null) 
			return 0;
		else 
			return Math.max(height(n.left), height(n.left))+1 ;  //왼쪽과 오른쪽 중에 큰놈+1;
		
	}
	public int size(Node n) {
		if(n==null) return 0;
		else return size(n.left)+size(n.right)+1;
	}
}
