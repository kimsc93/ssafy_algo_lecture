package algo_day_15;

public class fibo {
	static long fibo(long n) {
		if(n<2) return n;
		else return fibo(n-1)+fibo(n-2);
	}
	static long[] memo = new long[10000];
	static {
		memo[0]=0;
		memo[1]=1;
	}
	static long fibo_memo(int n) {
		if(n>=2 && memo[n]==0) {
			memo[n] =  fibo_memo(n-1)+fibo_memo(n-2);
		}
		return memo[n];
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		System.out.println(fibo(1000));
		System.out.println(fibo_memo(1000));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}
