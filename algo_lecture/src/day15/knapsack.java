package algo_day_15;

import java.util.Arrays;

public class knapsack {
	public static void main(String[] args) {
		int[][] item = {{10,5},
				{40,4},
				{30,6},
				{50,3}};
		int[] backpack = new int[11];
		for(int i=0;i<4;i++) {
			for(int j=backpack.length-1;j>=item[i][1];j--) {
				backpack[j] = Math.max(backpack[j],backpack[j-item[i][1]]+item[i][0] );
			}
		}
		System.out.println(Arrays.toString(backpack));
	}
}
