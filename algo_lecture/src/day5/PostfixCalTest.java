package algo_day5;

import java.util.Stack;

public class PostfixCalTest {
	public static void main(String[] args) {
		String expr = "6528-*2/+";

		// 수식을 순차적으로 탐색하며
		// 피연산자이면 스택에 담는다.
		// 연산자이면 연산자가 필요로 하는 갯수만큼 팝 해서 해당 연산을 수행 후 스택에 결과를 담는다.
		// 수식을 모두 순회했을때 스택에 남아있는 값이 결과!

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			if (Character.isDigit(expr.charAt(i))) {
				// 스택에 담는다.
				stack.push(expr.charAt(i) - '0');
			} else {
				// 스택에서 두개 꺼내서 해당 연산하고 결과를 다시 스택에 담는다.
				// 숫자가 아닌 경우인데 지금 우리 수식에선 숫자가 아니면 모두 연산자.
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch (expr.charAt(i)) {
				case '+':
					stack.push( num1 + num2 );
					break;
				case '-':
					stack.push( num1 - num2 );
					break;
				case '*':
					stack.push( num1 * num2 );
					break;
				case '/':
					stack.push( num1 / num2 );
					break;
				}
			}
		}
		System.out.println(stack.pop());
	}
}
