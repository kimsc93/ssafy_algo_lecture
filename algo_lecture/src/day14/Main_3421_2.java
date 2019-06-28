package algo_day_14;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
//정올 2634사냥꾼 과제
public class Main_3421_2 {
	public static void main(String[] args) {
		InputStream input = Main_3421_2.class.getResourceAsStream("input3421.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N];
			int[][] conflict = new int[N][N];
			for(int i=0;i<arr.length;i++) {
				arr[i]=i+1;
			}
			int[][] comb = new int[M][2];
			for (int i = 0; i < M; i++) {
				comb[i][0] = sc.nextInt();
				comb[i][1] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				conflict[ comb[i][0]-1 ][ comb[i][1]-1 ] =1;		//상극행렬 생성
				conflict[ comb[i][1]-1 ][ comb[i][0]-1 ] =1;
			}
//			for (int i = 0; i < conflict.length; i++) {
//				System.out.println(Arrays.toString(conflict[i]));
//			}					
			recur(N, conflict, new boolean[N], 0);
			System.out.println("#"+tc+" "+result);
			result=0;
		}		
	}
	static int result=0;
	static void recur(int N,int[][] conflict,boolean[] check,int cnt) {
		if(cnt==N) {
			result++;
			return ;			
		}
		boolean isOk =true;
		for(int i=0;i<check.length;i++) {
			if(check[i] && conflict[cnt][i]==1) {				
				isOk=false;
				break;
			}
		}
		if(isOk) {
			check[cnt] = true;
			recur(N,conflict,check,cnt+1);			
		}
		check[cnt] = false;
		recur(N,conflict,check,cnt+1);
	}
	static int pow(int n,int r) {
		if(r==1) return n;
		return n*pow(n,r-1);
	}
}
