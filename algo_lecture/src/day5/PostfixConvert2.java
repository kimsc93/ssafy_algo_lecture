package algo_day5;

import java.util.Stack;

public class PostfixConvert2 {
	public static void main(String[] args) {
		String expr = "(6+5*(2-8)/2)";
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if( Character.isDigit(c) )
				sb.append(c);
			else if( c == '(' )
				stack.push(c);
			else if( c == ')' ) {
				char tmp;
				while( !stack.isEmpty() && (tmp = stack.pop() )!= '(' ) {
					sb.append(tmp);
				}
			}
			else {
				while( !stack.isEmpty() &&  pre(c) <= pre(stack.peek()) ) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb.toString());
	}
	
	static int pre(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
			
		}
		return 0;
	}
}







