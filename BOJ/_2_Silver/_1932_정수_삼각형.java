package BOJ._2_Silver;
//[백준]1932 : 정수 삼각형 - JAVA(자바)

//< 알고리즘 유형 >
// DP

//< 알고리즘 풀이 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_정수_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<arr[i].length; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        dp[1][1] = arr[1][1];

        for(int i=2; i<=N; i++){         //depth
            for(int j=1; j<=N; j++){     //breath
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            if(max< dp[N][i]){
                max = dp[N][i];
            }
        }

        System.out.println(max);

    }
}
