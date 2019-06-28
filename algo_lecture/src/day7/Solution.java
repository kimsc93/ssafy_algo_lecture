
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int tc=1;tc<=T;tc++){
            int t = Integer.parseInt(b.readLine());
            int[] arr = new int[8];
            StringTokenizer st = new StringTokenizer(b.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 1;
            int idx = 0;
            while(true) {
                arr[idx]-=cnt++; //작업해야될 자리에 대해서 처리...
                if(arr[idx]<=0) {
                    arr[idx]=0; //종료조건을 만족하면 그만.
                    break;
                }
                if(cnt==6) {
                    cnt=1; //차감해야되는 양이 5를 넘어서면 다시 1부터..
                }
                idx = (++idx)%8; //0~7을 빙빙빙빙 돌게 하기 위한 모듈러
            }
            for(int i=0;i<arr.length;i++) {
                idx = (++idx)%8;
                sb.append(arr[idx]+" "); 
            }
            bw.write("#"+t+" "+sb.toString()+"\n");
            bw.flush();
        }
         
    }
}
