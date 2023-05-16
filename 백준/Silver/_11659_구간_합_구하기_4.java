package 백준.Silver;
//[백준]11659 : 구간 합 구하기 4 - JAVA(자바)

//< 나의 알고리즘 >
// DP 에 dp[i] = dp[i-1] + arr[i] 를 먼저 저장시키고
// 구간(i,j)가 주어지면  dp[j] 에서 dp[i-1] 를 빼주면 되지 않을까?

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_구간_합_구하기_4 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());   //수의 개수
        int M = Integer.parseInt(st.nextToken());   //구하는 횟수
        int[] arr = new int[N+1];

        dp = new int[N+1];

        //배열에 값 입력
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];

        for(int i=1; i<=N; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j]-dp[i-1]);
        }
    }
}
