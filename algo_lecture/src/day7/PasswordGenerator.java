
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class PasswordGenerator { // SW Expert 1225번

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<Integer>(); // 큐 선언

		for (int testCase = 0; testCase < 10; testCase++) { // 테스트케이스만큼 반복
			
			int T = sc.nextInt(); // 테스트 케이스의 번호를 입력
			
			for (int i = 0; i < 8; i++) { // 숫자 8개 입력받아서 큐에 박는다.
				queue.add(sc.nextInt());
			}
			// System.out.println("queue 똑바로 들어갔나 확인: " + queue);

			int cnt = 1; // 뺼수 1~5까지 증가했다가 다시 1이 되야함

			while (true) { // 큐의 원소값이 0보다 작거나 같아질 때까지 반복
				int temp = queue.poll(); // 첫번째 값 빼서 temp에 임시 저장

				// 뺼 수는 1~5까지 증가했다가 다시 돌아온다.
				if (cnt > 5) { // cnt가 5보다 크면 1로 재조정
					cnt = 1;
				}

				temp -= cnt;

				if (temp <= 0) { // 0보다 작거나 같아지면 프로그램을 멈추고 0으로 출력해야한다 (규칙)
					temp = 0;
					queue.add(temp); // 마지막 0인 수를 넣어서 출력해줘야한다.
					break;
				}

				queue.add(temp); // 뺀 수를 다시 큐의 맨 뒤에 삽입해준다.
				// System.out.println(queue);
				cnt++; // 다음 원소는 증가한 값만큼 빼야한다.

			}

			// 출력 부분
			System.out.print("#" + T + " ");
			for (int i = 0; i < 8; i++) {
				int temp = queue.poll();
				System.out.print(temp + " ");
			}
			System.out.println();
		}

	}

}
