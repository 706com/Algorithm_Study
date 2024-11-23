package BOJ._2_Silver;

//소요시간 : 30분 (실패 : 점화식 못세움 + 경우의수 잘못셈)
//[241123] : 10분

import java.io.*;

public class _11727_2xn_타일링_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = 3;
        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + (2 * dp[i-2]) % 10007) % 10007;
        }
        System.out.println(dp[N]);
    }
}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int[] dp = new int[N+1];
//
//        dp[1] = 1;
//        if(N>=2) {
//            dp[2] = 3;
//        }
//
//        for(int i=3; i<=N; i++){
//            dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
//        }
//        System.out.println(dp[N]);
//    }