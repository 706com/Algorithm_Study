package 백준_Solved_Class_3;
//[백준]1012 : 유기농 배추 - JAVA(자바)

//<새로 알게된 것>
// DFS(Depth First Search):깊이우선탐색 , BFS(Breadth First Search):너비우선탐색 문제
//

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1012_유기농_배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][N];

            //배추 심기(입력)
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
        }
    }
}
