package BOJ._1_Bronze;

//소요시간 : 6분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2748_피보나치_수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] dp = new Long[N+1];

        dp[0] = 0L;
        if(N>=1) {
            dp[1] = 1L;
        }

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        System.out.println(dp[N]);
    }
}
