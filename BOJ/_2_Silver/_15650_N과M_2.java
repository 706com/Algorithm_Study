package BOJ._2_Silver;
//[백준]15649 : N과 M(2) - JAVA(자바)

//< 나의 알고리즘 >
// 백트래킹
// N과 M (1) 에서 오름차순 조건 출력.

//< 답안 알고리즘 >
// visited 대신 point 변수로서 응용

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_N과M_2 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);
    }
    static void dfs(int point, int depth){
        if(depth == M){
            for(int value : arr){
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=point; i<=N; i++){
            arr[depth] = i;
            dfs(i+1,depth+1);
        }
    }
}
