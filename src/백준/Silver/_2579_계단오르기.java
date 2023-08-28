package 백준.Silver;
//[백준]2579 : 계단 오르기 - JAVA(자바)

//< 나의 알고리즘 >
// DP : Bottom-up 방식
// 2차원 배열 점화식 세우기..!

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_계단오르기 {
    static int[][] dp;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];
        score = new int[N+1];

        //계단에 점수입력
        for(int i=1; i<=N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        // 1일때 예외처리
        if(N==1){
            System.out.println(score[1]);
            return;
        }

        dp[1][1] = dp[1][2] = score[1];
        dp[2][1] = score[2];
        dp[2][2] = score[1] + score[2];

        for(int i=3; i<=N; i++){
            dp[i][1] = Math.max(dp[i-2][1] , dp[i-2][2]) + score[i];
            dp[i][2] = dp[i-1][1] + score[i];
        }

        int result = Math.max(dp[N][1],dp[N][2]);

        System.out.println(result);

    }
}
