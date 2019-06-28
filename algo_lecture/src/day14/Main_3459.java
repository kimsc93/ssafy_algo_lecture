package algo_day_14;

import java.io.InputStream;
import java.util.Scanner;

public class Main_3459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("5\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"7\r\n" + 
				"10\r\n" + 
				"123456789123456789");
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			long num = sc.nextLong();
			recur(win,1,num);
			System.out.println( "#"+tc+" "+ (win? "Bob" : "Alice") );
			win=true;
		}
	}
	static boolean win=true;
	static void recur(boolean turn,long game,long fin) {
		if(turn) {
			if(game*2+1 >= fin) {	//현재 값의 2n+1이 마지막숫자이상 도달하면 겜끝 	
				win=true;
				return ;
			}
			else {
				game=game*2;
				turn=false;
				recur(turn, game, fin);
			}			
		}
		else {
			if(game*2+1 >= fin) {	//현재 값의 2n+1이 마지막숫자이상 도달하면 겜끝 	
				win=false;
				return ;
			}
			else {
				game=game*2;
				turn=true;
				recur(turn, game, fin);
			}
		}
	}
}
