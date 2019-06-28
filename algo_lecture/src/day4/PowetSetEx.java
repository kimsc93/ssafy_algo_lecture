package algo_day4;

import java.util.Scanner;

public class PowetSetEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		System.out.println("숫자 3개를 입력하세요");
		for(int i = 0; i < 3; i++)
			arr[i] = sc.nextInt();
		
//		for(int i = 1 ; i <  ( 1 << arr.length ) ; i++) {
//			int sum = 0;
//			for(int j = 0; j < arr.length; j++) {
//				if( ( i & (1 << j) ) != 0 ) {
//					sum += arr[j];
//				}
//			}
//			if( sum == 0 )
//				System.out.println("0이 됩니다.ㅎ");
//		}
		recursive(arr, new boolean[arr.length], 0, 0);
	}
	static void recursive(int[] arr, boolean[] flag, int sum, int idx) {
		if(idx == arr.length) {
			//할일 다함
			if( sum == 0 ) {
				System.out.print("[");
				for(int i = 0; i < arr.length; i++) {
					if( flag[i])
						System.out.print(arr[i] + " ");
				}
				System.out.println("]");
			}
			return;
		}
		
		flag[idx] = true;
		recursive(arr, flag, sum + arr[idx], idx + 1);
		flag[idx] = false;
		recursive(arr, flag, sum , idx + 1);
	}
}





