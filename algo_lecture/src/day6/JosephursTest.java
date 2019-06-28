package algo_day6;

import java.util.LinkedList;
import java.util.Queue;

public class JosephursTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		
		
//		Queue<Integer> queue = new LinkedList<>();
//		for(int i = 0; i < arr.length; i++)
//			queue.add(arr[i]);
//		
//		int n = 10;
//		int k = 4;
//		int cnt = 0;
//		while( !queue.isEmpty() ) {
//			//일단 꺼내고 쿵쿵따 세기 시작함.
//			int poll = queue.poll();
//			cnt++;
//			
//			if(cnt == k) {
//				//쿵쿵따 타이밍 걸리면
//				System.out.println(poll);
//				cnt = 0;
//			}
//			else {
//				//쿵쿵따 아닐떄는 다시 뒤로가서 줄서.
//				queue.add(poll);
//			}
//		}
		
		
		// k 가 4일때 만들어지는 조세퍼스 순열을 출력해보시오 :)
		
		//첫칸부터 시작해서.... 오른쪽으로 한칸씩 이동이동....
		//네칸 이동했으면 출력....출력했으면 그자리 -1 오른쪽으로 이동이동....
		//네칸 이동했으면 출력....출력했으면 그자리 -1
		//끝까지 갔으면 처음부터 다시 오른쪽으로 이동이동....
		// 근데 -1인 곳은 이동카운트로 안치고 이동이동....
		//네칸 이동했으면 출력 .....
		//모두 한번씩 출력했으면 종료 . ...
		
//		int pos = 0; // 이동하는 위치.
//		int cnt = 0; // 쿵쿵따 카운트
//		int k = 4;
//		int n = 10;
//		int totalCnt = 0; // 삭제 횟수.
//		while(totalCnt != n) {
//			
//			//삭제된 녀석은 쿵쿵따 카운트 치지 않음.
//			if( arr[pos%n] != -1)
//				cnt += 1;
//			//쿵쿵따 걸려들면
//			if( cnt == k) {
//				//출력하고
//				System.out.println(arr[pos%n]);
//				//쿵쿵따 카운트 초기화
//				cnt = 0;
//				//죽은놈 마킹
//				arr[pos%n] = -1;
//				//토탈카운트 횟수 증가
//				totalCnt++;
//			}
//			//이동
//			pos += 1;
//		}
	}
}







