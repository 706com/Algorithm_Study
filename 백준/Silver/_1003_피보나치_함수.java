package 백준.Silver;
//[백준]1003 : 피보나치 함수 - JAVA(자바)

//<새로 알게된 것>
// 호출이 굉장히 많이 이루어지기 때문에 , dp알고리즘 으로 풀어야 함
// DP = Dynamic Programming = 동적 계획법 = 어떤 주어진 문제를 작은문제로 쪼개서 풀어나감에 있어 반복되는 호출을 줄이는 방법
// DP 가 일반 재귀와 다른점 -> 앞서 호출된 값이 있으면 그 값을 저장시켜 '재활용' 하는것
// 배열 초기화 : Arrays.fill(arr, value)

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1003_피보나치_함수 {
    static int[][] dp = new int[41][2]; //N의 최댓값 = 40


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        //dp[N][0 or 1]
        dp[0][0] = 1;   //N = 0 일 때, 0 호출 갯수
        dp[0][1] = 0;   //N = 0 일 때, 1 호출 갯수
        dp[1][0] = 0;   //N = 1 일 때, 0 호출 개수
        dp[1][1] = 1;   //N = 1 일 때, 1 호출 개수

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            //함수로 보내고 전역변수 출력
            fibonacci(N);
            System.out.println(dp[N][0]+" "+dp[N][1]);
        }
    }
    public static int[] fibonacci(int n){
        //2차원 배열 자동 초기화 = 0
        if (dp[n][0] == 0 && dp[n][1] == 0){
            dp[n][0] = fibonacci(n-2)[0] + fibonacci(n-1)[0];
            dp[n][1] = fibonacci(n-2)[1] + fibonacci(n-1)[1];
        }

        //dp는 2차원 배열이지만 반화형식은 1차원 배열인 것 잊지말기!
        //dp[n] 의 반환값 = dp[n][0],dp[n][1] 가 담겨있는 배열 반환
        //따라서 위에 if 문 안에 들어갈 내용은 dp[n-2][0] dp[n-1][0] 이라고 생각하면 됨
        return dp[n];
    }
}
