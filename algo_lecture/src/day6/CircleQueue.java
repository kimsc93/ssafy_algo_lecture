package algo_day6;

public class CircleQueue<T> implements IQueue<T> {
	private T[] queue;
	private int max = 10;
	private int front;
	private int rear;
	public CircleQueue() {
		// TODO Auto-generated constructor stub
		queue = (T[]) new Object[10];
	}
	public CircleQueue(int max) {
		this.max = max;
		queue = (T[]) new Object[max];
	}

	@Override
	public boolean enqueue(T data) {
		if( isFull() )
			return false;
		queue[++rear % max ] = data;
		return true;
	}

	@Override
	public T dequeue() {
		if( isEmpty() )
			return null;
		else
			return queue[ ++front % max];
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public boolean isFull() {
		return (rear + 1) % max == front;
	}

	@Override
	public T qPeek() {
		if( isEmpty() )
			return null;
		else
			return queue[ (front+1) % max];
	}
}
