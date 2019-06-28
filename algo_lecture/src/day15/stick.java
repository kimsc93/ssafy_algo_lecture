package algo_day_15;

public class stick {
	public static void main(String[] args) {
		System.out.println(stick(6));
		System.out.println(stick_memo(6));
		System.out.println(fibo_dp(9999));
		System.out.println(stick_dp(6));
	}
	static int stick_dp(int n) {
		int[] dp = new int[n+1];
		dp[1] = 2;
		dp[2] = 5;
		for(int i=3;i<n+1;i++) {
			dp[i] = 2*dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	static long fibo_dp(int n) {
		long[] dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<n+1;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	static int[] memo = new int[10000];
	static {
		memo[1] = 2;
		memo[2] = 5;
	}
	static int stick_memo(int n) {
		if(n>2 && memo[n] ==0) {
			memo[n] = stick_memo(n-2)+stick_memo(n-1)*2;
		}
		return memo[n];
	}
	//fn = fn-2 + fn-1*2
	static int stick(int n) {
		if(n==1) return 2;
		if(n==2) return 5;
		return stick(n-2)+stick(n-1)*2;
	}
}
