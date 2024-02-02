package BOJ._2_Silver;
//[백준]11726 : 2xn 타일링 - JAVA(자바)

//소요시간 : 5분

//오버플로우 생각하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_2xn_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;
        if(N>=2) {
            dp[2] = 2;
        }
        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
