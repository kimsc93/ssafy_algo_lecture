
public class NodeTest {
	public static void main(String[] args) {
		int size = 0;
		Node head = null;
		
		Node n1 = new Node();
		n1.data = 10;
		head = n1;
		size++;
		
		Node n2 = new Node();
		n2.data = 20;
		n1.link = n2;
		size++;
		
		Node n3 = new Node();
		n3.data = 30;
		n2.link = n3;
		size++;
		
		Node n4 = new Node();
		n4.data = 40;
		n3.link = n4;
		size++;
		
//		System.out.println(n1.link.link.data);
//		Node tmp = n1;
//		while( tmp.link != null ) {
//			tmp = tmp.link;
//		}
		
//		System.out.println("마지막 노드 : " + tmp.data);
		
		//3번째 노드...
		Node tmp = head;
		if( size > 3 ) {
			for(int i = 0; i < 2; i++) {
				tmp = tmp.link;
			}
			System.out.println(tmp.data);
		}
		
	}
}
