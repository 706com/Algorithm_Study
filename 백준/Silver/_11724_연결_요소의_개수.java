package 백준.Silver;
//[백준]11724 : 연결 요소의 개수 - JAVA(자바)

//< 나의 알고리즘 >
// 노드-간선 문제로 dfs 로 풀기.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724_연결_요소의_개수 {
    static int N,M;
    static int[][] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken());   //간선의 개수
        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        int count = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int start){
        visited[start] = true;

        for(int i=1; i<=N; i++){
            if(node[start][i] ==1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
