package algo_day6;

public class LinkedQueue<T> implements  IQueue<T>{
	Node<T> front;
	Node<T> rear;
	
	public boolean isEmpty(){
		return front == null ;
	}
	public boolean enqueue(T data) {
		if( isEmpty() ) {
			Node<T> tmp = new Node();
			tmp.data = data;
			front = tmp;
			rear = tmp;
		}
		else {
			Node tmp = new Node();
			tmp.data = data;
			rear.next = tmp;
			rear = tmp;
		}
		return true;
	}
	public T dequeue() {
		if( isEmpty() ) {
			System.out.println("빈큐");
			return null;
		}
		else {
			T data = front.data;
			front = front.next;
			if( front == null )
				rear = null;
			return data;
		}
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T qPeek() {
		// TODO Auto-generated method stub
		return null;
	}
}








