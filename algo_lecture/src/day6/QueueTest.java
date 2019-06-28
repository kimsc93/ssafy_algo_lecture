package algo_day6;

import java.util.Scanner;

public class QueueTest {
	public static void main(String[] args) {
		//여기서 사용하는 큐를 CircleQueue로 LinkedQueue로 바꿔서도 써보세요 :)
		
		
		
//		//1차원 배열 넉넉히 한개
//		int[] queue = new int[5];
//		//front 변수 준비, rear 변수 준비  ( 둘다 초기값 -1 )
//		int front = 0 , rear = 0;
		IQueue<Integer> queue = new LinkedQueue<>();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.Enqueue\n2.Dequeue\n0.End");
			int sel = sc.nextInt();
			
			if( sel == 0 )
				break;
			else if( sel ==  1 ) {
				// 사용자한테 숫자를 하나 입력받아서 Enqueue
				if(queue.isFull()) {
					System.out.println("FULL!!");
					break;
				}
				int tmp = sc.nextInt();
				queue.enqueue(tmp);
			}
			else if( sel == 2 ) {
				// Dequeue한 데이터를 출력
				if(queue.isEmpty())
					System.out.println("Empty");
				else
					System.out.println(queue.dequeue());
			}
		}
	}
}
