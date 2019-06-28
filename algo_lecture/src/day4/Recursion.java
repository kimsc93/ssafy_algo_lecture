package algo_day4;

public class Recursion {
	public static void main(String[] args) {
		Math.sqrt(10);
//		System.out.println(fact(3));
		System.out.println(fibo(3));
	}
	static int fact(int n ) {
		if( n == 1)
			return 1;
		else
			return n * fact(n-1);
	}
	static int fibo(int n ) {
		if( n < 2 )
			return n;
		else
			return fibo( n - 1 ) + fibo( n - 2 );
	}
}
