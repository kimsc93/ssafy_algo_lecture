package algo_day_11;

import java.io.InputStream;
import java.util.Scanner;
 
public class homework {
    public static void main(String[] args) {
    	InputStream input = homework.class.getResourceAsStream("test_input.txt");
    	System.setIn(input);
        Scanner sc = new Scanner(System.in);
                 
        for(int tc=1;tc<=10;tc++) {
        	sc.nextInt();
        	String str = sc.next();
        	String longStr = sc.next();
        	int cnt=0;
        	for(int i=0;i<longStr.length();i++) {
        		char c1 = longStr.charAt(i);
        		char c2 = str.charAt(0);
        		if(c1==c2) {
        			char[] ch = new char[str.length()];
        			for(int j=0;j<str.length();j++) {
        				if(i+j<longStr.length()) ch[j] = longStr.charAt(i+j);          				
        			}        			
        			if(str.equals(String.valueOf(ch))) {
        				cnt++;
        			}
        		}
        	}
        	System.out.println("#"+tc+" "+cnt);
        }
    }
}