package BOJ._2_Silver;
//[백준]11726 : 2xn 타일링 - JAVA(자바)

//소요시간 : 5분
//[241123] : 10분 (원리 이해 but 미숙)

import java.io.*;

public class _11726_2xn_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = 2;
        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007 ;
        }
        System.out.println(dp[N]);
    }
}




//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] dp = new int[N+1];
//
//        dp[1] = 1;
//        if(N>=2) {
//            dp[2] = 2;
//        }
//        for(int i=3; i<=N; i++){
//            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
//        }
//
//        System.out.println(dp[N]);
//    }
