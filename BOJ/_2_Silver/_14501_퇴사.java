package BOJ._2_Silver;

//소요시간 : 30분 (실패 : 구현실패)
//소요시간 : 1시간 30분


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        //dp[i] == 해당 일차에 받을 돈의 최대
        //ex) dp[7] == 6일차까지 "일을 다 끝내고" 7일차때 받을 돈 (6일차 밤 이라고 생각하면 편할듯?)
        // dp[8] == 7일차까지 "일을 다 끝내고" 8일차때 받을 돈 (7일차 밤 이라고 생각)
        int[] dp = new int[N+2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            if(i+T[i]<=N+1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i],dp[i+1]);
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[N+1]);
    }
}
