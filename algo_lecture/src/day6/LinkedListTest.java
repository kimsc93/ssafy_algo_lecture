package algo_day6;

import java.util.List;
import java.util.PriorityQueue;

public class LinkedListTest {
	public static void main(String[] args) {
		PriorityQueue list = new PriorityQueue();
		list.add(8);
		list.add(7);
		list.add(9);
		System.out.println(list.poll());
	}
}
