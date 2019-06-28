package day01;

import java.util.Arrays;

public class CombinationTest {
	public static void main(String[] args) {
		combination(new int[] {1,2,3,4,5}, new int[3], 0, 0);
	}
	static int[] discount = {0,0,10,20,30};
	static void combination(int[] arr, int[] result, int n, int r) {
		if(r == result.length) {
//			discount[result.length] : 할인율ㅋ
			System.out.println(Arrays.toString(result));
			
			return;
		}
		
		if(n == arr.length)
			return;
		
		//arr[n]을 선택. 아까는 n번째 boolean에 체크, 를 했다면 이번엔 result의 r번째에 값 자체를 저장.
		result[r] = arr[n];
		combination(arr, result, n+1, r + 1);
		combination(arr, result, n+1, r);
	}
}
