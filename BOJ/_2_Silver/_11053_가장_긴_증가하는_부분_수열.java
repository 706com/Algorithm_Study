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
        for(int i=0; i<N; i++){
            dp[i]= 1;
            for(int j=0; j<i; j++){
                //누적된 값은 크고, 해당 시퀀스 값은 작을때
                if(dp[i]<=dp[j] && arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
//            System.out.println(i+" "+dp[i]);
        }
        int result = 1;
        for(int x : dp){
            result = Math.max(result,x);
        }
        System.out.println(result);
    }
}
