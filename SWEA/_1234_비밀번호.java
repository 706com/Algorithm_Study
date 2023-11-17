package SWEA;

//19분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1234_비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while(count<=10) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String num = st.nextToken();

            for(int i=0; i<num.length()-1; i++) {
                if(num.charAt(i) == num.charAt(i+1)) {
                    String before = num.substring(0,i);
                    String after = num.substring(i+2);
                    num = before+after;
                    i=-1;
                }
//				System.out.println(num);
            }
            System.out.printf("#%d %s\n",count,num);
            count++;
        }
    }
}

//    public static void main(String[] args) throws IOException {
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        int T = 10;
//        int count = 1;
//        while(count<=T){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            String str = st.nextToken();
//
//            int start =0;
//            int end;
//            while(true) {
//                if(start==str.length()-1){
//                    break;
//                }
//                end = start + 1;
//                if (str.charAt(start) == str.charAt(end)) {
//                    str = str.substring(0, start) + str.substring(end+1, str.length());
//                    start = 0;
//                    continue;
//                }
//                start++;
//            }
//
//            System.out.printf("#%d %s\n",count,str);
//            count++;
//        }
//    }
