package BOJ._2_Silver;

//소요시간 : 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_파도반_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i=6; i<=100; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }
}
