package algo_day6;

public class MyLinkedList<T> {
	//단순 연결리스트를 구현해보시오
	// 1. add( T data )
	// 2. add( T data, int idx )  // idx번째 다음에 추가
	// 3. remove( int idx ) // idx번째 노드 삭제
	// 4. size 상태값 유지
	// 5. get(int idx)  // idx번째 값 리턴
	
	private int size;
	private Node<T> head; // 이 리스트의 첫번째 노드의 위치를 저장할 변수.
	public void add(T data) {
		Node<T> newNode = new Node();
		newNode.data = data;
		if( head == null ) {
			head = newNode;
		}
		else {
			Node n = head;
			while( n.next != null ) {
				n = n.next;
			}
			n.next = newNode;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node n = head;
		while(n != null) {
			sb.append(n.data + " ");
			n = n.next;
		}
		return sb.toString();
	}
}
