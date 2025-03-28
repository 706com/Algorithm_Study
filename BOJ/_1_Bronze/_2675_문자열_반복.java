package BOJ._1_Bronze;

//[250328] 8분

// JAVA 문자열은 * 연산 안됨 String.repeat() 연산 필요

import java.util.*;
import java.io.*;

public class _2675_문자열_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                sb.append((String.valueOf(str.charAt(i))).repeat(N));
            }
            System.out.println(sb);
        }
    }
}
