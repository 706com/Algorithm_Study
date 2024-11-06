package BOJ._2_Silver;

// [241106] 소요시간 : 30분 (실패)

import java.io.*;

public class _10844_쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        //일의 자리 경우의 수
        for(int i=1 ; i<10; i++){
            dp[1][i] = 1;
        }

        // 십의 자리 수 부터 N자리 수 까지 탐색
        for(int i=2; i<=N; i++){

            // i번째 자리의 0~10 경우의 수
            for(int j=0; j<10; j++){
                // 이전 숫자가 0이면, 1만 가능
                if(j==0){
                    dp[i][0] = dp[i-1][1];
                }
                // 이전 숫자가 9면, 8만 가능
                else if(j==9){
                    dp[i][9] = dp[i-1][8];
                }
                // 그 이외는 i-1번쨰 숫자의 +1 , -1 의 합이 경우의 수
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
                }
            }
        }

        long result = 0;

        for(int i=0; i<10; i++){
            result += dp[N][i];
        }
        System.out.println(result % 1_000_000_000);
    }
}
