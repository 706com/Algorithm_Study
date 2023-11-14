package BOJ._2_Silver;
//< 나의 알고리즘 >
// DP : Bottom-up 방식으로 풀기.
// 경로저장 방법을 생각치 못해서 실패.

//< 답안 알고리즘 >
// DP 테이블 말고도, 추가적으로 경로를 저장하는 테이블을 만들어서 , 경로를 용이하게 관리할 것.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852_1로_만들기_2 {
    static int[] dp;
    static int[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        route = new int[N+1];

        if(N==1){
            System.out.println("0");
            System.out.println("1");
            return;
        }
        dp[1] = 0;
        dp[2] = 1;

        route[1] = 1;
        route[2] = 1;

        for(int i=3; i<=N; i++){

            dp[i] = dp[i-1] +1;
            route[i] = i-1;

            if(i%2==0){
                if(dp[i] > dp[i/2]+1){
                    route[i] = i/2;
                }
                dp[i] = Math.min(dp[i] , dp[i/2]+1);
            }

            if(i%3==0){
                if(dp[i] > dp[i/3]+1){
                    route[i] = i/3;
                }
                dp[i] = Math.min(dp[i] , dp[i/3]+1);
            }
        }

        System.out.println(dp[N]);

//        for(int i=1; i<=N; i++){
//            System.out.print(route[i]+" ");
//        }
        int cur = N;
        sb.append(cur+" ");
        while(true){
            cur = route[cur];
            if(cur==1) {
                sb.append("1"+" ");
                break;
            }
            sb.append(cur+" ");
        }
        System.out.println(sb);
    }
}
