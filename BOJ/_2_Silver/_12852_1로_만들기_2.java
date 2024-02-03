package BOJ._2_Silver;

//소요시간 : 30분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852_1로_만들기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] index = new int[N+1];

        dp[1] = 0;
        index[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+1;
            index[i] = i-1;
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
                //만일 dp[i]의 값이 변경 되었다면 경로 추적
                if(dp[i] == dp[i/2]+1){
                    index[i] = i/2;
                }
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
                //만일 dp[i]의 값이 변경 되었다면 경로 추적
                if(dp[i] == dp[i/3]+1) {
                    index[i] = i/3;
                }
            }
        }
        // 경로 따라 출력
        System.out.println(dp[N]);
        int target = N;
        while(target != 1){
            System.out.print(target+" ");
            target = index[target];
        }
        System.out.print(target);
    }
}
