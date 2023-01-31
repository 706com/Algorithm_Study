package 백준_Solved_Class_3;
//<새로 알게된 것>
//bfs 거리 측정할 때 visit(boolean) 의 응용 -> dist(int)

//<궁금한 것>
// 어떻게 최솟값을 도출한거지? -> (방문한 곳은 continue 했으니, dist 값은 node의 dist +1)

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
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dist[i][j] = 0;
            }
        }

//        //확인
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=M; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        bfs(1,1);
        System.out.println(dist[N][M]);
    }
    public static void bfs(int x,int y){
        Queue<Node> q= new LinkedList<>();
        Node node = new Node(x,y);
        q.offer(node);
        dist[x][y]++;
        int count = 0;
        while(!q.isEmpty()){

            node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<1 || nx>N || ny<1 || ny>M ){
                    continue;
                }
                if(board[nx][ny] ==0 || dist[nx][ny] > 0){
                    continue;
                }
                dist[nx][ny] = dist[node.x][node.y]+1;
                q.offer(new Node(nx,ny));
            }
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            super();
            this.x = x;
            this.y = y;
        }
    }
}

