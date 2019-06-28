package algo_day_15;

import java.util.Scanner;

public class knapsack2 {
	static class Item{
		int cost, volume;

		public Item(int cost, int volume) {
			super();
			this.cost = cost;
			this.volume = volume;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			Item[] items = new Item[N];
			for(int i=0;i<N;i++) {
				items[i] = new Item(sc.nextInt(), sc.nextInt());
			}
			backtrack(items,new boolean[items.length],0,0,0,N,K);
			System.out.println(ans);
		}
	}
	static int ans=0;
	static void backtrack(Item[] items, boolean[] sel, int idx, int curVolume,int curCost,int N, int K) {
		if(idx==N) {
			//마지막 가방까지 검사완료
			if(ans<curCost)
				ans = curCost;
			return ;
		}
		//bound계산해서 현재로부터 얻을 수 있는 최대가치를 계산
		//현재 담아야될 아이템을 담을 수 있다면 tmpVolue, tmpCost에 누적합
		//담을 수 없다면 가성비로 무게당 가치 만큼만 tmp Cost에 더하고 tmpVolue는 맥스
		//해당 최대가치가 이미ㅣ 발견된 ans보다 작으면 return;
		
		//선택하는 경우
		if(curVolume+items[idx].volume<=K) {
			sel[idx] = true;
			backtrack(items,sel,idx+1,curVolume+items[idx].volume,curCost+items[idx].cost,N,K);
		}
		sel[idx] = false;
		backtrack(items,sel,idx+1,curVolume,curCost,N,K);
	}
	
}
