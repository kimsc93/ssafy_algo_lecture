package com.ssafy;

public class PowerSet {
	public PowerSet() {
//		method0(new int[] {3,2,1,4});
//		method1(new int[] {3,2,1,4});
		
		recur(0, 3);
	}
	void recur(int sum, int n) {
		if( n == 0) {
			System.out.println(sum);
			return;
		}
		
		recur( sum + n , n - 1);
		recur( sum , n - 1 );
		
	}
	//3. 재귀함수 : 내가 나를 호출 하는 함수.
	
	
	
	
	
	
	
	void printArr(int[] arr, boolean[] flag) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			if(flag[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("]");
	}
	
	//PowerSet을 구하는 방법
	//1. 다중 for문
	void method0(int[] arr) {
		//n개의 집합에 대해 대응이 되지 않으니, 그냥 4개짜리에 대해 처리로..
		if(arr.length == 4) {
			boolean[] flag = new boolean[4];
			for(int i = 0; i < 2; i++) {
				flag[0] = i %2 == 1 ? true:false;
				for(int j = 0; j < 2; j++) {
					flag[1] = j %2 == 1 ? true:false;
					for(int k = 0; k < 2; k++) {
						flag[2] = k %2 == 1 ? true:false;
						for(int l = 0; l < 2; l++) {
							flag[3] = l %2 == 1 ? true:false;
							printArr(arr, flag);
						}
					}
				}
				
			}
		}
	}
	//2. 비트마스크
	void method1(int[] arr) {
		
		
		//원소개 n개 라면 부분집합의 경우의 수 는 2^n 이므로, 0부터 2^n-1 까지의 경우를 검사하고 싶어요
		for(int i = 0; i <  (1 << arr.length) ;  i++ ) {
			boolean[] flag =  new boolean[arr.length];
			for(int j = 0; j < arr.length; j++) {
				if( ( i & (1 << j)  ) != 0 ) {
					//true
					flag[j] = true;
				}
			}
			printArr(arr, flag);
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new PowerSet();	
	}
}
