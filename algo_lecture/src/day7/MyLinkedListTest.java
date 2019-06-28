
public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list);
		list.add(40, 1);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		
	}
}
