
public class MyLinkedList {
	private int size;
	private Node head;
	
	public void remove(int idx) {
		if( size > idx ) {
			Node tmp = head;
			for (int i = 0; i < idx-1; i++) {
				tmp = tmp.link;
			}
			Node next = tmp.link.link;
			tmp.link = next;
			
		}
		else {
			System.out.println("IndexOutOfBoundException");
		}
	}
	
	public int get(int idx) {
		if( size > idx ) {
			Node tmp = head;
			for (int i = 0; i < idx; i++) {
				tmp = tmp.link;
			}
			return tmp.data;
		}
		else {
			System.out.println("IndexOutOfBoundException");
			return -1;
		}
	}
	public void add(int data, int idx) {
		//idx노드 뒤에 노드를 추가해보세요.
		if( size > idx ) {
			Node tmp = head;
			for (int i = 0; i < idx; i++) {
				tmp = tmp.link;
			}
			Node newNode = new Node();
			newNode.data = data;
			
			newNode.link = tmp.link;
			tmp.link = newNode;
			size++;
			
		}
		else {
			System.out.println("IndexOutOfBoundException");
		}
		
	}
	
	public void add(int data) {
		//추가되는 데이터를 저장할 새로운 노드를 생성해야됨.
		Node n = new Node();
		n.data = data;
		
		//이렇게 만든 노드객체를 맨 뒤에 연결시키고 싶은데.
		//아직 맨앞에가 비어있다는건, 한개도 없다는 것.
		//그러므로 맨 앞에다가 연결시켜주면 됨ㅇㅇ
		if( head == null ) {
			head = n;
		}
		else {
			//head에 어떤 노드가 연결되 있다면 
			Node tmp = head;
			while( tmp.link != null ) {
				tmp = tmp.link;
			}
			tmp.link = n;
		}
		size++;
	}
	public String toString() {
		//노드를 끝까지 탐색하며, 문자열에 값들을 이어붙여 리턴
		StringBuffer sb = new StringBuffer();
		Node tmp = head;
		while( tmp != null ) {
			sb.append(tmp.data + " ");
			tmp = tmp.link;
		}
		return sb.toString();
	}
}
