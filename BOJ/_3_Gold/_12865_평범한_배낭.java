package BOJ._3_Gold;

// < 알고리즘 유형 >
// dp

// < 풀이 접근 >
// *. 첫 줄에 물품의 수 N , 준서가 버틸 수 있는 무게 K
// *. 각 물건의 무게 W , 해당 물건의 가치 V
// *. dp 의 역할 : 담을 수 있는 무게가 1부터 시작하는 가방 용량. 그 중 최대의 가치.

// DP 점화식 f(i,k)
// 1) 0  : 인덱스 0 일 때
// 2) f(i-1,k) :  W[i] > k (현재 물품이 수용가능무게보다 클 때)
// 3. max(f(i-1,k-W[i]) + V[i] , f(i-1,k))


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _12865_평범한_배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 물품의 수
        int K = Integer.parseInt(st.nextToken());   // 준서가 들 수 있는 무게

        int[] W = new int[N+1];
        int[] V = new int[N+1];

        //dp 의 역할 : 담을 수 있는 무게가 1부터 시작하는 가방 용량. 그 중 최대의 가치.
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());   // 물품당 무게
            V[i] = Integer.parseInt(st.nextToken());    // 물품당 가치
        }

        // 첫번째 물품부터 채워넣기.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                // 현재 물품의 무게가 가방 수용량보다 클 때
                // -> dp 이전의 인덱스 무게로 (이전 물품은 가방에 넣었을 수도 있으니 )
                if(W[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                // 현재 물품 무게가 들 수 있는 무게 일 때
                // 비교대상 중, 최댓값 도출.
                // -> 비교 대상 1 : dp 이전의 인덱스 무게 (넣어놓은게 있는지)
                // -> 비교 대상 2 : 현재무게 + 남는공간 물건이 있었는가?
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , V[i] + dp[i-1][j-W[i]]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
