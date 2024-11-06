package BOJ._2_Silver;

// [241106] 소요시간 : 27분

import java.io.BufferedReader;
import java.util.Scanner;

public class _1788_피보나치_수의_확장 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int M = Math.abs(N);
        long[] dp = new long[M + 1];

        dp[0] = 0;

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        dp[1] = 1;
        if (N < 0) {
            if(N%2 == 0){
                System.out.println(-1);
            }
            else{
                System.out.println(1);
            }
            for (int i = 2; i <= M; i++) {
                dp[i] = (-dp[i - 1] + dp[i - 2]) % 1_000_000_000;
            }
            System.out.println(Math.abs(dp[M]) % 1_000_000_000);
        } else {
            System.out.println(1);
            for (int i = 2; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
            }
            System.out.println(dp[N]);

        }
    }
}
