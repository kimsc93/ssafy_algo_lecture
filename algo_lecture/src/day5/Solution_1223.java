package algo_day5;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			sc.next();
			String expr = sc.next();
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < expr.length(); i++) {
				char c = expr.charAt(i);
				if( Character.isDigit(c) )
					sb.append(c);
				else {
					if( c == '+') {
						while( !stack.isEmpty() && stack.peek() == '*' ) {
							sb.append(stack.pop());
						}
					}
					stack.push(c);
				}
			}
			while(!stack.isEmpty())
				sb.append(stack.pop());
			
			String infixExpr = sb.toString();
			Stack<Integer> calStack = new Stack<>();
			for (int i = 0; i < infixExpr.length(); i++) {
				if (Character.isDigit(infixExpr.charAt(i))) {
					calStack.push(infixExpr.charAt(i) - '0');
				} else {
					int num2 = calStack.pop();
					int num1 = calStack.pop();
					switch (infixExpr.charAt(i)) {
					case '+':
						calStack.push( num1 + num2 );
						break;
					case '*':
						calStack.push( num1 * num2 );
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + calStack.pop());
		}
	}
}
