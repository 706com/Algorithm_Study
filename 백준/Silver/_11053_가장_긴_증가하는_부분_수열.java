package 백준.Silver;
//[백준]11053 : 가장 긴 증가하는 부분 수열 - JAVA(자바)

//< 나의 알고리즘 >

//< 답안 알고리즘 >
// DP 문제.
// == 최장 증가 부분 수열 (LIS) 라고도 한다.
// DP 임에도 불구하고, 시간복잡도가 O(N^2) 이다.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

            }
        }
    }
}
