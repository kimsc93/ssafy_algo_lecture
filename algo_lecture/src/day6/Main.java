package algo_day6;

import java.util.Scanner;
import java.util.Stack;


// 7
// 6 5 4 8 3 10 9

// 0 1 2 0 4 0 6
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<int[]> stack = new Stack<>(); //탑을 저장할 스택..
		int N = sc.nextInt();//탑의 개수.
		for(int i = 1; i <= N; i++) {
			int height = sc.nextInt();
			// stack에 탑을 검사해서 나보다 더 작은놈은 팝.  <- 나보다 큰놈이 올때까지 반복.
			while( !stack.isEmpty() && stack.peek()[0] < height ) {
				stack.pop();
			}
			if( stack.isEmpty() )
				System.out.print(0);
			else
				System.out.print(stack.peek()[1]);
			
			stack.push(new int[] {height, i});
			System.out.print(" ");
		}
	}
}
