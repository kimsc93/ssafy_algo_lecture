import java.util.Arrays;

//0단계 총합
//1단계 부분집합
//2단계 조합
//3단계 순열
public class Recur {
	public static void main(String[] args) {
//		sum(3, 0);
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
//		arrSum(arr,0,0,0,0);
//		powersetSum(arr,0,0, new boolean[arr.length]);
		int [] sel = new int[3];
//		combination(arr, sel,0, 0);
		perm(arr, 0);
	}
	
	//순열
	static void perm(int[] arr, int n) {
		if( arr.length == n )
		{
//			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i = n; i < arr.length; i++) {
			swap(arr,i,n);
			perm(arr,n+1);
			swap(arr,i,n);
		}
	}
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	//조합
	static void combination(int[] arr , int[] sel, int n, int r) {
		if( r == sel.length)
		{
			System.out.println(Arrays.toString(sel));
			return;
		}
		if( n == arr.length) {
			return;
		}
		sel[r] = arr[n];
		combination(arr, sel, n+1, r+1);
		combination(arr, sel, n+1, r);
		
	}
	
	
	//부분집합.
	static void powersetSum(int[] arr, int idx, int sum, boolean[] selected) {
		if( idx == arr.length ) {
			for(int i = 0; i < arr.length; i++)
			{
				if(selected[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println(" = " + sum);
			return;
		}
		selected[idx] = false;
		powersetSum(arr, idx+1, sum, selected);
		selected[idx] = true;
		powersetSum(arr, idx+1, sum + arr[idx], selected);
	}
	
	
	//총합
	static void sum(int n, int sum) {
		if( n == 0 ) {
			System.out.println(sum);
			return;
		}
		sum(n-1, sum+n);
	}
	//배열의 총합
	static void arrSum(int[] arr, int idx, int sum) {
		if( idx == arr.length) {
			System.out.println(sum);
			return;
		}
		
		if( arr[idx] % 2 == 1 ) {
			arrSum(arr, idx+1, sum + arr[idx]);
		}
		else {
			arrSum(arr, idx+1, sum);
		}
		
	}
	
	
	
}
