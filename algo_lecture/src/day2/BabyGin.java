package algo_day2;

import java.util.Arrays;

public class BabyGin {
	public static void main(String[] args) {
		int cnt = 0;
		int[] arr = {6,6,7,7,6,7};
//		for(int i = 0; i < 6; i++) {
//			arr[i] = (int)(Math.random() * 9);
//		}
		
		//6중 for문 모든 순열...ㄱ
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if( i != j ) {
					for(int k = 0; k < 6; k++) {
						if( k != i && k != j)	{
							for(int l = 0; l < 6; l++) {
								if( l != i && l != j && l != k ) {
									for(int m = 0; m < 6; m++) {
										if( m != i && m != j && m != k && m != l) {
											for(int n = 0; n < 6; n++) {
												if( n != i && n != j && n != k && n != l && n != m ) {
//													System.out.printf("%d %d %d %d %d \n" , i, j,k,l,m,n);
													int[] arr2 = new int[6];
													arr2[0] = arr[i];
													arr2[1] = arr[j];
													arr2[2] = arr[k];
													arr2[3] = arr[l];
													arr2[4] = arr[m];
													arr2[5] = arr[n];
													int isBabyGin = 0;
													if( arr2[0] + 1 == arr2[1] && arr2[1] + 1 == arr2[2]  ) {
														isBabyGin++;
													}
													if( arr2[0] == arr2[1] && arr2[1] == arr2[2]) {
														isBabyGin++;
													}
													if( arr2[3] + 1 == arr2[4] && arr2[4] + 1 == arr2[5]  ) {
														isBabyGin++;
													}
													if( arr2[3] == arr2[4] && arr2[4] == arr2[5]) {
														isBabyGin++;
													}
													if( isBabyGin == 2 ) {
														System.out.println("BabyGin!!! : " + cnt);
														System.out.println(Arrays.toString(arr2));
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}




