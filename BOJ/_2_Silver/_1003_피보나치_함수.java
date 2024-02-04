package BOJ._2_Silver;
//[백준]1003 : 피보나치 함수 - JAVA(자바)

//소요시간 : 12분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_피보나치_함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][2];

            if(N>=0) {
                dp[0][0] = 1;
                dp[0][1] = 0;
            }
            if(N>=1) {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }
            if(N>=2) {
                dp[2][0] = 1;
                dp[2][1] = 1;
            }
            for(int i=3; i<=N; i++){
                dp[i][0] = dp[i-2][0] + dp[i-1][0];
                dp[i][1] = dp[i-2][1] + dp[i-1][1];
            }
            sb.append(dp[N][0]).append(' ').append(dp[N][1]).append('\n');
        }
        System.out.println(sb);
    }
}
