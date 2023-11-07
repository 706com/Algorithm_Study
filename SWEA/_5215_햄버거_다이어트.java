package SWEA;

// < 알고리즘 유형 >
// DP

// < 풀이 접근 >
// *. knapsack 문제와 비슷하다.
// 1. 재료마다의 점수와 칼로리를 넣는 배열을 만든다.
// 2. DP 를 이용하여, 가장 최고의 점수를 만들 수 있는 것을 찾는다.
// -> DP 의 역할 : 칼로리를 뜻하는 인덱스 , 인덱스 값 : 그 칼로리 안에서 점수 중 가장 높은 값.


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _5215_햄버거_다이어트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int result = 0;

            int[] score = new int[N+1];
            int[] kcal = new int[N+1];
            int[][] dp = new int[N+1][L+1];

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=L; j++){
                    if(kcal[i] > j){
                        dp[i][j] = dp[i-1][j];
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j],score[i]+dp[i-1][j-kcal[i]]);
                    }
                }
            }
            result = dp[N][L];

            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
}
