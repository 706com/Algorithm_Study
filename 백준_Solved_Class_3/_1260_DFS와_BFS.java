package 백준_Solved_Class_3;
//[백준]1260 : DFS와 BFS - JAVA(자바)

//<새로 알게된 것>
//배열 초기화 : Arrays.fill
//기존 dfs,bfs 와 다르게, 노드와 간선으로 생각했을 경우의 문제.

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1260_DFS와_BFS {
    static int N,M;
    static int[][] connectLine;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());    //정점의 개수 (1<=N<=1,000)
        M = Integer.parseInt(st.nextToken());    //간선의 개수 (1<=M<=10,000)
        int V = Integer.parseInt(st.nextToken());    //탐색할 정점의 번호
        connectLine= new int[N+1][N+1];
        visit = new boolean[N+1];

        //노드 - 간선 연결짓기
        for(int i=1; i<=M; i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connectLine[a][b] = connectLine[b][a] = 1;
        }
        //dfs 돌리기
        dfs(V);
        System.out.println();

//        //모든 노드를 탐색하면 안됨 : 반례 이유 : //www.acmicpc.net/board/view/51403
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                if(connectLine[i][j] != 1 || visit[i] == true){
//                    continue;
//                }
//                dfs(V);
//            }
//        }

        //방문여부 초기화
        Arrays.fill(visit,false);

        //bfs 돌리기
        bfs(V);

//        //마찬가지로 모든 노드 탐색하면 안됨
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                if(connectLine[i][j] != 1 || visit[i] == true){
//                    continue;
//                }
//                bfs(V)
//            }
//        }
    }

    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v+" ");

        for(int i=1; i<=N; i++){
            if(connectLine[v][i] != 1 || visit[i] == true){
                continue;
            }
            dfs(i);
        }

    }

    public static void bfs(int v){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=1; i<=N; i++){
                if(connectLine[temp][i] != 1 || visit[i] == true) {
                    continue;
                }
                q.offer(i);
                visit[i] = true;
            }
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}

