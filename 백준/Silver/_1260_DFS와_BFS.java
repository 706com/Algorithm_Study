package 백준.Silver;
//[백준]1260 : DFS와 BFS - JAVA(자바)

//< 나의 알고리즘 >
// dfs - 스택(재귀) , bfs - 큐로 구현

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFS와_BFS {
    static StringBuilder sb = new StringBuilder();

    static int N,M,V;
    static int[][] node;
    static boolean[] visited;

    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken());   //간선의 개수
        V = Integer.parseInt(st.nextToken());   //탐색 시작할 정점의 번호

        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        //노드-간선 연결
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        //DFS 수행
        dfs(V);

        //방문기록 초기화
        visited = new boolean[N+1];
        sb.append('\n');

        //BFS 수행
        bfs(V);

        System.out.println(sb);
    }
    static void dfs(int start){
        visited[start] = true;
        sb.append(start+" ");

        for(int i=1; i<=N; i++){
            if(node[start][i] ==1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start+" ");

            for(int i=1; i<=N; i++){
                if(node[start][i] ==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
