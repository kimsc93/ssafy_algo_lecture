package algo_day6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mychu {
	static class Person{
		Person(int num){
			this.num = num;
		}
		int num;
		int cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Person> queue = new LinkedList<>();
		int pNum = 1;
		int mychu = 19;
		queue.add(new Person(1));
		while (true) {
			Person receiver = queue.poll();
			receiver.cnt++;
			queue.add(receiver);
			queue.add(new Person(++pNum));
			mychu -= receiver.cnt;
			if( mychu <= 0 ) {
				System.out.println(receiver.num + "가 먹음");
				break;
			}
//			System.out.println(receiver.num + "이가 마이쮸를 " + receiver.cnt + "개 먹었습니다." );
//			sc.nextLine();
		}
		
		// dequeue 된놈이 enqueue 인데 dequeue가 없어...
		// enqueue 1
		
		// dequeue 된놈이 enqueue
		// enqueue 2
		
		// dequeue 된놈이 enqueue
		// enqueue 3
				
		
		//1번이가 줄을 슨다.
		
		//1번이가 나온다
		//1번이가 줄을슨다.
		//2번이가 줄을슨다.
		
		//1번이가 나온다.
		//1번이가 줄을슨다.
		//3번이가 줄을슨다.
		
		//2번이가 나온다.
		//2번이가 줄을슨다.
		//4번이가 줄을슨다.
		
		//1번이가 나온다.
		//1번이가 줄을슨다.
		//5번이가 줄을슨다.
	}
}
