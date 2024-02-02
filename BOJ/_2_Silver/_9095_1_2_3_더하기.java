package BOJ._2_Silver;
//[백준]9095 : 1,2,3 더하기 - JAVA(자바)

//소요시간 : 9분
//DP : Bottom Up

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_1_2_3_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4; i<=10; i++){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }
}
