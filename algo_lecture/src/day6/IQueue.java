package algo_day6;

public interface IQueue<T> {
	// enqueue dequeue  isEmpty  isFull  qPeek 의 기능
	boolean enqueue(T data);
	T dequeue();
	boolean isEmpty();
	boolean isFull();
	T qPeek();
}
