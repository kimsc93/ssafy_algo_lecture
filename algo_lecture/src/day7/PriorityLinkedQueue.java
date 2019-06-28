
public class PriorityLinkedQueue {
	public static void main(String[] args) {
		PriorityLinkedQueue queue = new PriorityLinkedQueue();
		queue.add(1);
		queue.add(3);
		queue.add(7);
		System.out.println(queue);
		queue.enqueue(5);
		System.out.println(queue);
	}
	Node front;

	public void enqueue(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (front == null) {
			front = newNode;
		} else {
			Node tmp = front;
			while (tmp.link != null && newNode.data > tmp.link.data) {
				tmp = tmp.link;
			}
//			System.out.println(tmp.data);
			newNode.link = tmp.link;
			tmp.link = newNode;
			
			//tmp에 들어있는놈 : 내가 들어갈 자리의 앞놈
		}
	}
	public void add(int data) {
		//추가되는 데이터를 저장할 새로운 노드를 생성해야됨.
		Node n = new Node();
		n.data = data;
		
		//이렇게 만든 노드객체를 맨 뒤에 연결시키고 싶은데.
		//아직 맨앞에가 비어있다는건, 한개도 없다는 것.
		//그러므로 맨 앞에다가 연결시켜주면 됨ㅇㅇ
		if( front == null ) {
			front = n;
		}
		else {
			//head에 어떤 노드가 연결되 있다면 
			Node tmp = front;
			while( tmp.link != null ) {
				tmp = tmp.link;
			}
			tmp.link = n;
		}
	}
	public String toString() {
		//노드를 끝까지 탐색하며, 문자열에 값들을 이어붙여 리턴
		StringBuffer sb = new StringBuffer();
		Node tmp = front;
		while( tmp != null ) {
			sb.append(tmp.data + " ");
			tmp = tmp.link;
		}
		return sb.toString();
	}
}
