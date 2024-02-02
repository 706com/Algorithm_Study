package BOJ._2_Silver;
//[백준]2579 : 계단 오르기 - JAVA(자바)

//소요시간 : 21분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_계단_오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[][] dp = new int[N+1][3];   // [1번째 계단부터 시작]

        for(int i=1; i<=N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[1][1] = score[1];    // 첫번째 계단 연속 1번 밟았을 때
        if(N>=2) {
            dp[2][1] = score[2];               // 두번째 계단 연속 1번 밟았을 때
            dp[2][2] = score[1] + score[2];    //두번째 계단 연속 2번 밟았을 때
        }

        for(int i=3; i<=N; i++){
            dp[i][1] = score[i] + Math.max(dp[i-2][2],dp[i-2][1]);
            dp[i][2] = score[i] + dp[i-1][1];
        }
        int result = Math.max(dp[N][1],dp[N][2]);
        System.out.println(result);
    }
}
