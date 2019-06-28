package algo_day4;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
	
	static class MyStack{
		private int top;
		private int[] stack;
		private int size;
		public MyStack(int size) {
			stack = new int[size];
			this.size = size;
			top = -1;
		}
		public void push(int num) {
			top += 1;
			if( top == size ) {
				//overflow
				throw new StackOverflowError();
			}
			else
				stack[top] = num;
		}
		public int pop(){
			if( isEmpty() ) {
				throw new EmptyStackException();
			}
			else
			{
				return stack[top--];
			}
		}
		public boolean isEmpty() {
			if( top == - 1)
				return true;
			else
				return false;
		}
		public int peek() {
			if( isEmpty() ) {
				throw new EmptyStackException();
			}
			return stack[top];
		}
		public int size() {
			return top+1;
		}
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Scanner sc = new Scanner(System.in);
		MyStack stack = new MyStack(3);
		while(true) {
			System.out.println("1. push ( 입력 예 : 1 10 ) \n2. pop (입력 예 : 2 ) 0. 종료");
			int sel = sc.nextInt();
			if ( sel == 0 )
				break;
			else if( sel == 1 ) {
				//작성
				stack.push(sc.nextInt());
			}
			else if( sel == 2 ) {
				//작성
				System.out.println(stack.pop());
			}
		}
	}
}




