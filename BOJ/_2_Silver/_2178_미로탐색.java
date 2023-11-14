package BOJ._2_Silver;
//[백준]2178 : 미로 탐색 - JAVA(자바)

//< 나의 알고리즘 >
// 최단경로탐색 = bfs 로 풀이
// visited 대신 방문여부를 dist로 표현

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색 {
    static int N,M;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];


        // 보드에 값 입력
        // dist 는 모두 -1 로 초기화
        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                int num = Character.getNumericValue(str.charAt(j));
                board[i][j] = num;
                dist[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                // 미로에 길이 있고(1) , 아직 방문하지 않았다면(-1) bfs돌리기
                if(board[i][j] == 1 && dist[i][j] == -1){
                    bfs(i,j);
                }
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dist[N-1][M-1]+1);
    }
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        dist[x][y] +=1; //방문한곳 dist증가

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx>=N || ny>=M || nx<0 || ny<0)
                    continue;
                if(board[nx][ny] == 0 || dist[nx][ny] != -1)
                    continue;

                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] + 1;
            }
        }
    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x= x;
            this.y= y;
        }
    }
}
