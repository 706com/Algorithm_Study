package 백준.Silver;
//[백준]1789 : 수들의 합 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디

//< 알고리즘 풀이 >
// stack overflow 를 조심하여 , dp 로 풀기.

//< 새로 알게된 것 >


//< 궁금한 것 >

import java.io.*;

public class _1789_수들의_합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[] dp = new long[10000000];

        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] += dp[i-1] + i;
            if(dp[i]>N){
                System.out.println(i-1);
                break;
            }
        }
    }
}
