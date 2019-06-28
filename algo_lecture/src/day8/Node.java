package algo_day4_2;

public class Node {
	int data;
	Node left;
	Node right;
	public Node(int data, Node left,Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public String toString() {
		return "["+ data+"]";
	}
}

//public static void main(String[] args) {
////	Node a = new Node();
////	Node b = new Node();
////	Node c = new Node();
////	Node d = new Node();
////	Node e = new Node();
////	Node f = new Node();
////	Node g = new Node();
////	Node h = new Node();
////	Node i = new Node();
////	Node j = new Node();
////	Node k = new Node();
////	Node l = new Node();
////	
////	a.left = b;
////	a.right = c;
////	b.left = d;
////	b.right = e;
////	c.left =f;
////	c.right =g;
//	
//	Node root = new Node();
//	data_preorder(root);
//	preorder(root);
//}