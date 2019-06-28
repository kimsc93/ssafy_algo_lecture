package algo_day4;

import java.util.Scanner;
import java.util.Stack;

public class Ex2 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		String brackets = new Scanner(System.in).nextLine();
		boolean isOk = true;
		for(int i = 0; i < brackets.length(); i++) {
			char c = brackets.charAt(i);
			//열림이면 스택에 넣고
			if( c == '(' )
				stack.push(c);
			else {
				//닫힘이면 마지막 스택이 열림인지 확인
				//  닫힘인데 마지막 스택이 열림이 아니면 부적합
				//  닫힘인데 스택이 비어 있으면 부적합
				if( stack.isEmpty() || stack.pop() != '(' ) {
					isOk = false;
					break;
				}
			}
		}
		
		if( !stack.isEmpty() || !isOk)
			System.out.println("부적합");
		else
			System.out.println("적합");
	}
}
