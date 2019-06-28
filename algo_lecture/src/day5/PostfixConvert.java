package algo_day5;

import java.util.Stack;

public class PostfixConvert {
	public static void main(String[] args) {
		String expr = "9+5*2+1+3*3+6";
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if( Character.isDigit(c) )
				sb.append(c);
			else {
				if( c == '+') {
					while( !stack.isEmpty() && (stack.peek() == '*' || stack.peek()== '+') ) {
						sb.append(stack.pop());
					}
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb.toString());
	}
}
