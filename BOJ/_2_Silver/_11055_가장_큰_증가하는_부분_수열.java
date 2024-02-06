package BOJ._2_Silver;

//소요시간 : 40분 (실패 : 구현 중 뇌절)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11055_가장_큰_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp의 역할 : 지금까지 순서대로 온 수열들의 합
        // -> 오름차순 순서대로 온 것이라는 것을 인지할 것
        dp[0] = arr[0];

        for(int i=1; i<N; i++){
            int target = i; //변수명 헷갈려서!

            for(int j=i-1; j>=0; j--){
                // 1. 타겟의 현재 값이 이전 값들보다 커야함 (arr)
                // 2. 타겟의 dp 값이 이전 dp들 보다 작아야함 (dp)
                if(arr[target]>arr[j]){
                    dp[target] = Math.max(dp[target],dp[j]+arr[target]);
                }
            }
            // 본인이 가장 큰 작은값 (순서가 첫번째 일 경우)
            if(dp[target]==0) {
                dp[target] = arr[target];
            }
        }
//        System.out.println(Arrays.toString(dp));
        // 가장 큰 합 찾기
        int max = 0;
        for(int x : dp){
            max = Math.max(max,x);
        }
        System.out.println(max);

    }
}
