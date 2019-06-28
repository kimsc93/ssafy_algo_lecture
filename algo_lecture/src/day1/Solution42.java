
import java.io.InputStream;
import java.util.Scanner;

public class Solution42 {
	static int N, Si, Sj, P, D;
	static int Ai, Aj; // coord
	
	public static void main(String[] args) throws Exception{
		InputStream input = Solution42.class.getResourceAsStream("Solution42.txt");
        System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 배열의 크기
			Si = sc.nextInt(); //출발점의 i좌표;
			Sj = sc.nextInt(); //출발점의 j좌표;
			P = sc.nextInt(); // 점퍼 개수
			
			int Pi[] = new int[P];  // 점퍼의 i좌표 모음
			int Pj[] = new int[P];  // 점퍼의 j좌표 모음
			
			for(int k=0; k<P; k++) {
				Pi[k] = sc.nextInt();
				Pj[k] = sc.nextInt();
			}
			D = sc.nextInt();
			int Dd[] = new int[D];  // 방향 선언 1 - 상 2 - 우 3 - 하 4 - 좌
			int Da[] = new int[D];  // 이동 선언
			
			for(int k=0; k<D; k++) {
				Dd[k] = sc.nextInt(); // 방향 입력받음
				Da[k] = sc.nextInt(); // 이동 수 입력받음.
			}
			
			//TODO 미로 선언, 플레이어, 점퍼 배치
			int [][] maze = new int[N+1][N+1];
			
			maze[Si][Sj] = 1;
			
			for(int i = 0; i < P ;i++)
			{
				maze[Pi[i]][Pj[i]] = 2;
			}
			
			//TODO Direction + Move
			out : for(int i=0; i< D;i++)
			{
				if(Dd[i] == 1) {
					for(int j = 0 ; j < Da[i];j++) {
						Si -= 1;
						
						if(Si > N || Si <= 0)
						{
							Ai = 0;
							Aj = 0;
							break out;
						}
						if (maze[Si][Sj] == 2) {
							Ai = 0;
							Aj = 0;
							break out;
						}
						else
						{
							Ai = Si;
							Aj = Sj;
						}
					}
				}
				else if(Dd[i] == 2)
				{
					for(int j = 0 ; j < Da[i];j++) {
						Sj += 1;
						if(Sj > N || Sj <= 0)
						{
							Ai = 0;
							Aj = 0;
							break out;
						}
						if (maze[Si][Sj] == 2) {
							Ai = 0;
							Aj = 0;
							break out;
						}
						else
						{
							Ai = Si;
							Aj = Sj;
						}
					}
				}
				else if(Dd[i] == 3)
				{
					for(int j = 0 ; j < Da[i];j++) {
						Si += 1;
						
						if(Si > N || Si <= 0)
						{
							Ai = 0;
							Aj = 0;
							break out;
						}
						if (maze[Si][Sj] == 2) {
							Ai = 0;
							Aj = 0;
							break out;
						}
						else
						{
							Ai = Si;
							Aj = Sj;
						}
					}
				}
				else if(Dd[i] == 4)
				{
					for(int j = 0 ; j < Da[i];j++) {
						Sj -= 1;
						
						if(Sj > N || Sj <= 0)
						{
							Ai = 0;
							Aj = 0;
							break out;
						}
						if (maze[Si][Sj] == 2) {
							Ai = 0;
							Aj = 0;
							break out;
						}
						else
						{
							Ai = Si;
							Aj = Sj;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+Ai+" "+Aj);
		}
		sc.close();
	}
}
























