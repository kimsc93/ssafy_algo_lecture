package algo_day4_2;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		btree.setRoot(new Node(1,null,null));
		btree.addLeft(btree.getRoot(), new Node(2,null,null));
		btree.addRight(btree.getRoot(), new Node(3,null,null));
	}
}
