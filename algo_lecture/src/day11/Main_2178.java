package algo_day_11;

import java.util.LinkedList;
import java.util.Scanner;

//backjun.com 2178 경로찾기문제는 dfs x bfs가 좋음
public class Main_2178 {
	static int min = 100000;
	static int count=0;
	static class Status {
		int r, c, cnt;

		Status(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[] delr= {-1,1,0,0};
	static int[] delc= {0,0,-1,1};
	public static void main(String[] args) {
		String input = "7 7\r\n" + 
				"1011111\r\n" + 
				"1110001\r\n" + 
				"1000001\r\n" + 
				"1000001\r\n" + 
				"1000001\r\n" + 
				"1000001\r\n" + 
				"1111111";
		Scanner sc = new Scanner(input);
		//첫줄은 행과 열의 정보입니다. 4행 6열
		// 그 다음부터 행의 갯수만큼 미로 길 정보가 들어옵니다.
		//2차원 배열에 위 입력을 담아보세요.
		int row = sc.nextInt();
		int col = sc.nextInt();		
		int[][] arr= new int[row+1][col+1];
		
		for(int i=1;i<=row;i++) {
			String str = sc.next();
			for(int j=1;j<=col;j++) {
				arr[i][j] = str.charAt(j-1)-'0';
			}			
		}
		//dfs(arr,new boolean[row+1][col+1],1,1,1);
		bfs(arr,new boolean[row+1][col+1]);
		System.out.println(min);
	}
	static void bfs(int[][] map,boolean[][] visited) {
		//큐 생성
		//0,0좌표의 카운트1 정보를 큐에 삽입
		//방문 체크
		//큐가 빌때까지
		//	큐에서 꺼내서 목적지인지 확인 >> 목적지이면 min값에 현재cnt 저장
		//	이동가능한 방향 중 아직 방문 안했으면 큐에 담고 방문표기
		LinkedList<Status> list = new LinkedList<>();
		list.add(new Status(1,1,1));
		visited[1][1] = true;
		while(!list.isEmpty()) {
			Status st= list.poll();
			if(st.c==map[0].length-1 && st.r==map.length-1) {
				min = st.cnt;
				return;
			}
				
			for(int i=0;i<delr.length;i++) {
				int nr = st.r + delr[i];
				int nc = st.c + delc[i];	
				if( nr<1 || nr>=map.length || nc<1 || nc >=map[0].length ) {
					continue;
				}
				if(!visited[nr][nc] && map[nr][nc]==1) {
					list.add(new Status(nr,nc,st.cnt+1));
					visited[nr][nc]=true;
				}
			}			
		}		
	}

	//지도정보, 방문체크배열,현재 방문할 좌표, 지금까지 카운트
	static void dfs(int[][] arr,boolean[][] check,int y,int x, int cnt) {
		//if 이번좌표 == y,x
//			지금까지 카운트 중 최소값 기억
//		동서남북 ㅂ려로 지도 밖으로 나가지 않으면서 1인값을 가지는 곳 재귀호출.
		if(y>arr.length-1 || y<0 || x>arr[0].length-1 || x<0) { //범위밖벗어나면 끝냄
			return;
		}
		if(y==arr.length-1 && x==arr[0].length-1) {
			if(min>cnt) {
				min=cnt;
			}
			return;
		}
		cnt++;
		check[y][x]=true;
		if(y-1>=0 && !check[y-1][x] && arr[y-1][x]==1) {	//위
			dfs(arr,check,y-1,x,cnt);
		}
		if(y+1<arr.length && !check[y+1][x] && arr[y+1][x]==1) {	//아래
			dfs(arr,check,y+1,x,cnt);
		}
		if(x-1>=0 && !check[y][x-1] && arr[y][x-1]==1) {	//좌
			dfs(arr,check,y,x-1,cnt);
		}
		if(x+1<arr[0].length && !check[y][x+1] && arr[y][x+1]==1) {	//우
			dfs(arr,check,y,x+1,cnt);
		}
		cnt--;
		check[y][x]=false;
	}
}
