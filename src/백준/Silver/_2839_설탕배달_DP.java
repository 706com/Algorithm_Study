package 백준.Silver;
//[백준]2839 : 설탕 배달 - JAVA(자바)

//< 나의 알고리즘 >

//< 답안 알고리즘 >
// DP로 풀기. 3과 5로 값이 결정되기 때문에, +1씩 증가해주면 된다.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2839_설탕배달_DP {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp= new int[N+1];

        //초깃값 설정
        if(N>=3)
            dp[3] = 1;
        if(N>=5)
            dp[5] = 1;

        for(int i=6; i<=N; i++){
            if(i%5 == 0){
                dp[i] = dp[i-5]+1;
            }
            else if(i%3 == 0){
                dp[i] = dp[i-3]+1;
            }
            else{
                if(dp[i-3] != 0 && dp[i-5] != 0){
                    dp[i] = Math.min(dp[i-3],dp[i-5])+1;
                }
            }
        }

        if(dp[N] == 0){
            System.out.println("-1");
            return;
        }
        System.out.println(dp[N]);
    }
}
