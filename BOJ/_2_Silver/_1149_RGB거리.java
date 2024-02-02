package BOJ._2_Silver;
//[백준]1149 : RGB거리 - JAVA(자바)

//소요시간 : 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N+1][3];
        int[][] dp = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = cost[1][0];  //R
        dp[1][1] = cost[1][1];  //G
        dp[1][2] = cost[1][2];  //B

        for(int i=2; i<=N; i++){
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);    //R(현재 집) + G,B(이전 집)중에서 택
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);    //G(현재 집) + R,B(이전 집)중에서 택
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);    //B(현재 집) + R,G(이전 집)중에서 택
        }

        int result = Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]);
        System.out.println(result);
    }
}
