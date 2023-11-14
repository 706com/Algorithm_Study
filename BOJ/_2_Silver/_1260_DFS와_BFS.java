package BOJ._2_Silver;
// < 알고리즘 유형 >
// 그래프 탐색

// < 풀이 접근 >
// 1. 노드와 간선을 연결한다.
// 2. DFS 를 구현한다. (재귀 or Stack)
// 3. 초기화를 진행한다.
// 4. BFS 를 구현한다. (Queue)
// 5. 값을 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1260_DFS와_BFS {

    static int[][] arr;
    static boolean[] visited;

    static int N,M,V;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 1. 노드와 간선을 연결한다.
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        // 2. DFS 를 구현한다. (재귀 or Stack)
        dfs(V);

        // 3. 초기화를 진행한다.
        visited = new boolean[N+1];
        sb.append('\n');

        // 4. BFS 를 구현한다. (Queue)
        bfs(V);

        // 5. 값을 출력한다.
        System.out.println(sb);

    }

    static void dfs(int num){
        visited[num] = true;
        sb.append(num).append(" ");
        for(int i=1; i<=N; i++){
            if(!visited[i] && arr[num][i] == 1){
                dfs(i);
            }
        }
    }
    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visited[num] = true;
        sb.append(num).append(' ');

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && arr[node][i] ==1){
                    q.offer(i);
                    visited[i] = true;
                    sb.append(i).append(' ');
                }
            }
        }
    }
}
