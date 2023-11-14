package BOJ._2_Silver;
//[백준]11726 : 2xn 타일링 - JAVA(자바)

//< 나의 알고리즘 >
// 9095 문제 1,2,3 더하기와 비슷해보인다.
// 여기서는 1과 2 더하기처럼 생각하면 될 듯 싶다.
// dp[i] = dp[i-1] + dp[i-2] 로 접근하면 될 것 같다.
// overflow 방지를 위해 넣는 과정에서 10007 나머지를 넣는다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_2xn타일링 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        //예외처리
        if(N==1){
            System.out.println("1");
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
