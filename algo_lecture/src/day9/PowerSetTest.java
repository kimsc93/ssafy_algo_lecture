package day01;

public class PowerSetTest {
	public static void main(String[] args) {
		powetSet(new int[] {1,2,3,4}, new boolean[4], 0,0);
	}
	
	static void powetSet(int[] arr, boolean[] sel,int k, int cnt) {
		if( cnt == 2 )
		{
			//다고름
			return;
		}
		if(k == arr.length)
		{
			//다검사
			return;
		}
		sel[k] = true;
		powetSet(arr, sel, k+1,	cnt+1);
		sel[k] = false;
		powetSet(arr, sel, k+1, cnt);
	}
	
	static void bitmask(int[] arr) {
		int size = 1 << arr.length;
		System.out.println(size);
		for(int i = 0 ; i < size; i++) {
			System.out.print("{");
			for(int j = 0 ; j < arr.length; j++) {				
				 if((i & (1 << j)) != 0) {
					 System.out.print(arr[j] + " ");
				 }				 
			}
			System.out.println("}");
		}
	}
}
