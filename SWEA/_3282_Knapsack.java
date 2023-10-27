package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3282_Knapsack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N+1][K+1];

            int[] V = new int[N+1];	//부피
            int[] C = new int[N+1];	//가치
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=K; j++) {

                    // 배낭크기 < 부피
                    if( j < V[i]) {
                        dp[i][j] = dp[i-1][j];
                    }
                    // 현재 물품 무게가 들 수 있는 무게 일 때
                    // 비교대상 중, 최댓값 도출.
                    // -> 비교 대상 1 : dp 이전의 인덱스 무게 (넣어놓은게 있는지)
                    // -> 비교 대상 2 : 현재무게 + 남는공간 물건이 있었는가?
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], C[i] + dp[i-1][j-V[i]]);
                    }
                }
            }

            System.out.printf("#%d %d\n",count,dp[N][K]);
            count++;
        }
    }
}
