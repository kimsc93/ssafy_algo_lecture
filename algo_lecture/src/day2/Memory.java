package algo_day2;

import java.util.Scanner;

public class Memory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			char[] input = sc.next().toCharArray();
			int cnt = 0;
			if( input[0] == '1')
				cnt++;
			
			for(int i = 1; i < input.length; i++)
			{
				if(input[i-1] != input[i])
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
