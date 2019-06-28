package day01;

import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		char[] ch = str.toCharArray();
		int[] arr = new int[ch.length];
		for(int i=0;i<ch.length;i++) {
			switch (ch[i]) {
			case 'A':
				arr[i] = 10;
				break;
			case 'B':
				arr[i] = 11;
				break;
			case 'C':
				arr[i] = 12;
				break;
			case 'D':
				arr[i] = 13;
				break;
			case 'E':
				arr[i] = 14;
				break;
			case 'F':
				arr[i] = 15;
				break;
			default:
				arr[i] = ch[i] - '0';
			}			
		}
		for(int i:arr)
		System.out.println(i);
		
		for(int i:arr) {
			System.out.print(Arrays.toString(change_to_bit(i)).replaceAll("[^0-9]","")) ;
			System.out.print(" ");
		}
			
		System.out.println();
		for(int i:arr)
			System.out.print( change_to_dec(change_to_bit(i)) +" " ) ;;
	}
	public static int[] change_to_bit(int a) {
		int[] bit = new int[7];
		for(int i=0;i<7;i++) {			
			bit[6-i]=a%2; 
			a /=2;
		}		
		return bit;
	}
	public static int change_to_dec(int[] arr) {
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[6-i]==1) {
				sum+=pow(2,i);
			}			
		}
		return sum;
	}
	public static int pow(int a,int n) {
		if(n==0) return 1;
		if(n==1) return a;
		return a*pow(a,n-1);
	}
}
