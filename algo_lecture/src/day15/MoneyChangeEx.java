package algo_day_15;

import java.util.Arrays;

public class MoneyChangeEx {
	public static void main(String[] args) {
		int n = 20;
		int[] coins = { 1, 16,5,10 }; // 사용 가능한 동전 종류
		int[] dp = new int[n + 1];

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < dp.length; j++) {
				if (i == 0)
					dp[j] = j;
				else
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
			System.out.println(Arrays.toString(dp));
		}
	}
}
