package BOJ._2_Silver;
//[백준]1012 : 유기농 배추 - JAVA(자바)

//< 나의 알고리즘 >
// dfs(재귀) 로 풀면 될 것이다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1012_유기농_배추 {
    static int M,N,K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        while(T-->0) {

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            M = Integer.parseInt(st.nextToken());   //가로길이
            N = Integer.parseInt(st.nextToken());   //세로길이
            K = Integer.parseInt(st.nextToken());   //배추의 개수
            board = new int[N][M];
            visited = new boolean[N][M];

            int count = 0;

            // board 에 배추심기 : 주의! : 제공되는게 X , Y 순이라 [b][a] 로 집어넣어야함
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[b][a] = 1;
            }

            // DFS 돌리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M){
                continue;
            }
            if(board[nx][ny] != 1 || visited[nx][ny]){
                continue;
            }
            dfs(nx,ny);
        }
    }
}
