package BOJ._2_Silver;
//[백준]1932 : 연속합 - JAVA(자바)

//< 알고리즘 유형 >
// DP

//< 알고리즘 풀이 >
// LIS 와 비슷해보인다. 연속합이 음수가 되지 않는 구간으로 설정하여 나아가기 (X)
// LIS 가 아닌,,, 그냥 메모리제이션으로 앞서 누적해나온 값과 비교하면 끝..

//< 새로 알게된 것 >

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i] ,arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N;i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
