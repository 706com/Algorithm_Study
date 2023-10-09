package 문제해결력연습;

// < 알고리즘 유형 >
// dp

// 다시풀기 요망 (이게 왜 됐지)

// < 풀이 접근 >
// *. DP 역할 : 현재 금액으로 만들수 있는 갯수의 중첩 (1부터 순차적으로)
//  -> 해당 값이 들어올 때 초기화해주기
//

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _3067_Coins {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());    //동전 가지수
            StringTokenizer st= new StringTokenizer(br.readLine());

            int[] V = new int[N+1]; //동전 가격
            for(int i = 1; i<=N; i++) {
                V[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());    //만들어야 할 금액
            int[][] dp = new int[N+1][M+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if( j - V[i] ==0) {
                        dp[i][j] = 1;
                    }
                }
            }
            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(V[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] += (dp[i - 1][j]) + (dp[i][j - V[i]]);
                    }
                }
            }
            sb.append(dp[N][M]).append('\n');
        }
        System.out.println(sb);
    }
}
