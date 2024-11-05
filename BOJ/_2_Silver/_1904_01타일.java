package BOJ._2_Silver;

// [241105] 소요시간 : 15분

import java.io.*;
import java.util.*;

public class _1904_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;
        if(N>1) {
            dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
            }
        }
        System.out.println(dp[N]);

    }
}
