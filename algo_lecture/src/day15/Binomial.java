package algo_day_15;

public class Binomial {
	public static void main(String[] args) {
		System.out.println(bino_dp(10,2));
	}
	static int bino_dp(int n, int k) {	//이항계수
		int[][] dp = new int[n+1][k+1];
		dp[0][0]=1;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<k+1;j++) {
				//j가 고르는 갯수 k 
				//i가 모집단 갯수 n
				//iCj가 nCk의 부분문제
				if(j==0||j==i) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
				}
			}
		}
		return dp[n][k];
	}
	static int[][] memo = new int[10000][10000];
	static {
		for(int i=0;i<10000;i++) {
			memo[i][0]=1;
			memo[i][i]=1;
		}
	}
	
	static int bino_memo(int n ,int k) {
		if(memo[n][k] ==0)
			memo[n][k] = bino_memo(n-1,k-1)+bino_memo(n-1,k);
		return memo[n][k];
	}
	static int bino(int n ,int k) {
		if(n==k||k==0) return 1;
		return bino(n-1,k-1)+bino(n-1,k);
	}
}
