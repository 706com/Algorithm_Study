package BOJ._2_Silver;

//소요시간 : 14분 (실패 : 범위초과)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] dp = new Long[N+1];
        dp[1] = 1L;
        if(N>=2) {
            dp[2] = 1L;
        }

        for(int i=3; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[N]);
    }
}
