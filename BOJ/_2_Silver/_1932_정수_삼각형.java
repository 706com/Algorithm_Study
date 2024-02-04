package BOJ._2_Silver;
//[백준]1932 : 정수 삼각형 - JAVA(자바)

//소요시간 : 23분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1932_정수_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + arr[i][j];
                dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i-1][j]);
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max,dp[N][i]);
        }
        System.out.println(max);
    }
}
