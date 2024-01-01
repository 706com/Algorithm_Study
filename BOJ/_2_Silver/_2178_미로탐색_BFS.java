package BOJ._2_Silver;

//소요시간 : 12분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색_BFS {
    static int N,M;
    static int[][] board;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {-1,1,0,0};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());   //세로 (2<=N<=100)
        M = Integer.parseInt(st.nextToken());   //가로 (2<=M<=100)
        board = new int[N+1][M+1];
        dist = new int[N+1][M+1];

        //입력 (board,dist)
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                char c = str.charAt(j-1);
                board[i][j] = Character.getNumericValue(c);
            }
        }

        bfs(1,1);

        System.out.println(dist[N][M]);
    }
    public static void bfs(int x,int y){
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(x,y));
        dist[x][y] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<=0 || nx>N || ny<=0 || ny>M ){
                    continue;
                }
                if(board[nx][ny] ==0 || dist[nx][ny] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y]+1;
            }
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}

