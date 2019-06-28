package algo_day_16;
import java.util.Scanner;
public class Main_3304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			char[] strArr1 = new char[str1.length()+1];
			char[] strArr2 = new char[str2.length()+1];
			int[][] matrix = new int[str1.length()+1][str2.length()+1];
			for(int i=1;i<=str1.length();i++) {
				strArr1[i] = str1.charAt(i-1);
			}
			for(int i=1;i<=str2.length();i++) {
				strArr2[i] = str2.charAt(i-1);
			}
			for(int i=1;i<matrix.length;i++) {
				for(int j=1;j<matrix[0].length;j++) {
					if (strArr1[i] == strArr2[j]) {
						matrix[i][j] = matrix[i - 1][j-1] + 1;
					}
					else {
						int max = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
						matrix[i][j] = max;
					}
				}
			}
			System.out.println("#"+tc+" "+matrix[matrix.length-1][matrix[0].length-1]);
		}
	}
}
