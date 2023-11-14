package BOJ._3_Gold;
//[백준]7576 : 토마토 - JAVA(자바)

//< 나의 알고리즘 >
// 기존과 달리, 여러 방향에서 퍼져나가는 문제이다. bfs 로 풀며 queue 에 미리 한번에 넣어줘야한다.
// 또한 visited 대신 dist 로 하여 날짜를 출력한다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_토마토 {
    static int N,M;
    static int[][] board;
    static int[][] dist;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];

        // 토마토 입력
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
//                dist[i][j] = -1;
            }
        }

        // 토마토가 심어져있는(1) 부분을 모두 q 에 담아버리고 bfs돌리기.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 1 && dist[i][j] == 0){
                    q.offer(new Node(i,j));
                }
            }
        }
        bfs();

        // board 돌면서 하나라도 0 인 부분이 있으면 -1 출력.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
            }
        }

        // dist 돌면서 최댓값 찾기
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(max < dist[i][j])
                    max = dist[i][j];
            }
        }
        System.out.println(max);


    }
    static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(board[nx][ny] != 0 || dist[nx][ny] != 0){
                    continue;
                }

                q.offer(new Node(nx,ny));
                board[nx][ny] = 1;
                dist[nx][ny] = dist[node.x][node.y] +1 ;
            }
        }
    }


    static class Node{
        int x;
        int y;

        Node(int x,int y){
            this.x =x;
            this.y= y;
        }
    }
}
