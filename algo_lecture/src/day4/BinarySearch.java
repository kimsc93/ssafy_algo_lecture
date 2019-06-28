package algo_day4;


import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	boolean bSearch(int a[],int key) {
		int s=0;
		int max=a.length;
		int mid=0;
		if(a[max-1]<key) {
			return false;
		}
		while(s<=max) {
			mid=(s+max)/2;
			System.out.println("s : " + s + ", max : " + max + " , a[mid]" + a[mid]);
			if(a[mid]==key) {
				return true;
			}else if(a[mid]>key) {
				max=mid-1;
			}else if(a[mid]<key){
				s=mid+1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열의 길이를 입력하세요");
		int n=sc.nextInt();
		System.out.println("배열을 입력하세요");
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println("확인할 숫자를 입력하세요");
		BinarySearch b=new BinarySearch();
		int key=sc.nextInt();
		
		System.out.println(b.bSearch(arr,key));
		

	}

}
