package 백준.Silver;
//[백준]1149 : RGB거리 - JAVA(자바)

//< 나의 알고리즘 >
// DP : bottom-up 으로, 2차원배열로 RGB 구성.


//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //집의 수
        int[][] house = new int[N+1][4];

        dp = new int[N+1][4];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            house[i][1] = red;
            house[i][2] = green;
            house[i][3] = blue;
        }

        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        dp[1][3] = house[1][3];

            //점화식
            //dp[N][1] (red)일 때 : N-1 의 집의 blue, green 의 가격 중 작은것과 더하기.
            //dp[N][2] (green)일 때 : N-1 의 집의 red, blue 의 가격 중 작은것과 더하기.
            //dp[N][3] (blue)일 때 : N-1 의 집의 red, green 의 가격 중 작은것과 더하기.
            for(int i=2; i<=N; i++){
                dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + house[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][3];
        }

        int result = Math.min( Math.min(dp[N][1],dp[N][2]) , dp[N][3]);
        System.out.println(result);
    }

}
