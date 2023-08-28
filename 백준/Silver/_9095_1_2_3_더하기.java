package 백준.Silver;
//[백준]9095 : 1,2,3 더하기 - JAVA(자바)

//< 나의 알고리즘 >
// DP 로 점화식을 구해서 bottom-up 방식으로 풀기

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_1_2_3_더하기 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
        }

//        for(int i=1; i<11; i++){
//            System.out.print(dp[i]+" ");
//        }

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
