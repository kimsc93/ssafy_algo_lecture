package day01;

import java.util.Scanner;

public class BitEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int sum = 0;
		for(int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			int idx = 6-i % 7;
			int num = c - '0';
			if( num == 1 ) {
				sum += ( num << idx );
			}
			if( i % 7 == 6 ) {
				System.out.println(sum);
				sum = 0;
			}
		}
	}
}
