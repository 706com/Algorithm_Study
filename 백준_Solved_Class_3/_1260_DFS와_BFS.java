package 백준_Solved_Class_3;
//[백준]1260 : DFS와 BFS - JAVA(자바)

//<새로 알게된 것>
//

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
//        for(int i=1; i<=N; i++){
//            connectLine[i][i] =1;
//        }

//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(connectLine[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(connectLine[i][j] != 1 || visit[i] == true){
                    continue;
                }
                bfs(V);
            }
        }
    }

    public static void bfs(int v){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;
        //sb.append(v).append(" ");

        while(!q.isEmpty()){
            int temp = q.poll();
            //System.out.println(temp);

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

