package BOJ._2_Silver;
//[백준]2839 : 설탕 배달 - JAVA(자바)

//< 나의 알고리즘 >
// 3을 기점으로 값이 결정되니 그리디로 접근.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2839_설탕배달_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5];

        Arrays.fill(dp,-1);
        int min = Integer.MAX_VALUE;

        for(int i =0; i<=4; i++){
            if((N - 3*i) % 5 == 0 && (N-3*i)>=0) {
                dp[i] = ((N - 3 * i) / 5) + i;
                System.out.println(dp[i]);
                return;
            }
        }

        System.out.println(-1);
    }
}
