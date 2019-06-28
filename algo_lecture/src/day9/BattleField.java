package day01;


import java.io.InputStream;
import java.util.Scanner;

public class BattleField {
	public static void main(String[] args) {
		InputStream input = BattleField.class.getResourceAsStream("input.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<T;tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();			
			char[][] map = new char[H][W];		
			int curI=0;
			int curJ=0;
			char curDir='>';
			for(int i=0;i<H;i++) {
				String strW = sc.next();
				map[i] = strW.toCharArray();
			}			
			int instructLength = sc.nextInt();
			String instruct = sc.next();
			char[] instCh = new char[instructLength];
			for(int i=0;i<instructLength;i++) {
				instCh[i] = instruct.charAt(i);
			}
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]=='^'||map[i][j]=='<'||map[i][j]=='>'||map[i][j]=='v') {
						curI=i;
						curJ=j;
						curDir=map[i][j];
					}
				}
			}
			for(int i=0;i<instructLength;i++) {
				switch(instCh[i]) {
				case 'U':
					curDir='^';
					map[curI][curJ] = '^';
					if(curI-1>=0 && map[curI-1][curJ]!='-' && map[curI-1][curJ]=='.') {						
						map[curI][curJ] = '.';
						curI-=1;
						map[curI][curJ] = '^';
					}
					break;
				case 'D':
					curDir='v';
					map[curI][curJ] = 'v';
					if(curI+1<H &&  map[curI+1][curJ]!='-' && map[curI+1][curJ]=='.') {
						map[curI][curJ] = '.';
						curI+=1;
						map[curI][curJ] = 'v';
					}
					break;
				case 'L':
					curDir='<';
					map[curI][curJ] = '<';
					if(curJ-1>=0 && map[curI][curJ-1]!='-' && map[curI][curJ-1]=='.') {
						map[curI][curJ] = '.';
						curJ-=1;
						map[curI][curJ] = '<';
					}
					break;
				case 'R':
					curDir='>';
					map[curI][curJ] = '>';
					if(curJ+1<W && map[curI][curJ+1]!='-'&& map[curI][curJ+1]=='.') {
						map[curI][curJ] = '.';
						curJ+=1;
						map[curI][curJ] = '>';
					}
					break;
				case 'S':
					shoot(map,curI,curJ,curDir);
					break;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}		
				
		}	
		
	}
	public static void shoot(char[][] map,int curI,int curJ,char curDir) {
		switch(curDir){
		case '>':
			while(true) {
				curJ++;
				if(curJ>map[0].length-1) break;	
				else if(map[curI][curJ]=='*') {
					map[curI][curJ]='.';
					break;
				}
				else if(map[curI][curJ]=='#') break;		
			}
			break;
		case '<':
			while(true) {
				curJ--;
				if(curJ<0) break;	
				else if(map[curI][curJ]=='*') {
					map[curI][curJ]='.';
					break;
				}
				else if(map[curI][curJ]=='#') break;						
			}
			break;
		case '^':
			while(true) {
				curI--;
				if(curI<0) break;	
				else if(map[curI][curJ]=='*') {
					map[curI][curJ]='.';
					break;
				}
				else if(map[curI][curJ]=='#') break;						
			}
			break;
		case 'v':
			while(true) {
				curI++;
				if(curI>map.length-1) break;	
				else if(map[curI][curJ]=='*') {
					map[curI][curJ]='.';
					break;
				}
				else if(map[curI][curJ]=='#') break;						
			}
			break;
		}
	}
}
