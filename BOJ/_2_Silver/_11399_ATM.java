package BOJ._2_Silver;
//[백준]11399 : ATM - JAVA(자바)

//< 알고리즘 유형 >
// 그리디 , 정렬

//< 알고리즘 풀이 >
// dp 를 이용하여 더한 값들을 저장해놓는 방법 사용.


//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _11399_ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dp[0] = arr[0];
        int sum = dp[0];

        for(int i=1; i<N; i++){
            dp[i] = dp[i-1] + arr[i];
            sum += dp[i];
        }

        System.out.println(sum);
    }

}
