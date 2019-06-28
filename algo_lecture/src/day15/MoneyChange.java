package algo_day_15;

import java.util.Arrays;

public class MoneyChange {
	public static void main(String[] args) {
		int n = 10;
		int[] coins = {1,4,6};
		int[] dp = new int[n+1];
		//1원만 고려하는 경우
		for(int i=coins[0];i<n+1;i++) {
			dp[i] = i;
		}
		System.out.println(Arrays.toString(dp));
		//4원을 추가로 고려하는 경우
		for(int i =coins[1] ; i<n+1;i++) {
			dp[i] = Math.min(dp[i], dp[i-coins[1]]+1);
		}
		System.out.println(Arrays.toString(dp));
		//6원
		for(int i =coins[2] ; i<n+1;i++) {
			dp[i] = Math.min(dp[i], dp[i-coins[2]]+1);
		}
		System.out.println(Arrays.toString(dp));
		
	}
}
