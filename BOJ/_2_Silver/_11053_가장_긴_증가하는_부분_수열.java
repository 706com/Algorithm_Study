package BOJ._2_Silver;
//[백준]11053 : 가장 긴 증가하는 부분 수열 - JAVA(자바)

//소요시간 : 38분 (실패 : 구현실패)

// == 최장 증가 부분 수열 (LIS) 라고도 한다.
// DP 임에도 불구하고, 시간복잡도가 O(N^2) 이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i=1; i<N; i++){
            int target = i; // 변수명 헷갈려서
            dp[target] = 1; // 1부터 시작

            for(int j=i-1; j>=0; j--){
                if(arr[target]>arr[j] && dp[target]<=dp[j]){
                    dp[target] = Math.max(dp[target],dp[j]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        int max = 1;
        for(int x : dp){
            max = Math.max(max,x);
        }
        System.out.println(max);
    }
}
