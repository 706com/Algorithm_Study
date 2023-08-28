package 백준.Silver;
//[백준]2606 : 바이러스 - JAVA(자바)

//< 나의 알고리즘 >
// 네트워크 : dfs(재귀) 로 풀어야겠다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2606_바이러스 {
    static int[][] board;
    static int N,M;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //컴퓨터의 수
        M = Integer.parseInt(br.readLine());    //간선
        board = new int[N+1][N+1];
        visited = new boolean[N+1];

        //노드 간선 연결
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = board[b][a] = 1;
        }

        bfs(1);

        System.out.println(count-1);
    }

    static void bfs(int start){
        visited[start] = true;
        count++;

        for(int i=1; i<=N; i++){
            if(board[start][i]==1 && !visited[i]){
                bfs(i);
            }
        }
    }
}
