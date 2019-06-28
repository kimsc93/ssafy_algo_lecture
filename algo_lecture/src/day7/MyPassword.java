import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyPassword {

	public static void main(String[] args) {
		
		InputStream input = MyPassword.class.getResourceAsStream("input.txt");
		System.setIn(input);		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0;tc<10;tc++) {
			List<Integer> list = new LinkedList<>();
			int N = sc.nextInt();
			int x,y;			
			for(int i=0;i<N;i++) {
				list.add(sc.nextInt());
			}
			int instructNum = sc.nextInt();
			for(int i=0;i<instructNum;i++) {
				String insert = sc.next();
				x = sc.nextInt();
				y = sc.nextInt();
				for(int j=0;j<y;j++) {
					list.add(x, sc.nextInt());
					x++;
				}				
			}
			//System.out.println(list);
			System.out.print("#"+(tc+1)+" ");
			for(int i=0;i<10;i++) System.out.print(list.get(i)+" ");
			System.out.println();			
		}				
	}
	
}
//Node[] n = new Node[arr.length];
//Node[] sArr = new Node[y];
//
//	Node temp = new Node();
//for(int i=0;i<arr.length;i++) n[i] = new Node();
//for(int i=0;i<y;i++) sArr[i] = new Node();
//for(int i=0;i<arr.length;i++) {				//입력받은 값 노드화
//	n[i].data = arr[i];
//	if(i<arr.length-1) n[i].link = n[i+1];		
//}
//for(int i=0;i<y;i++) {				//입력받은 값 노드화
//	sArr[i].data = s[i];
//	if(i<y-1) sArr[i].link = sArr[i+1];		
//}
//temp.data = n[0].data;
//temp.link = n[0].link;
//
//for(int i=0;i<x;i++) {
//	temp = temp.link;
//}
//sArr[y-1].link = temp.link;
//temp.link = sArr[0];