package 백준_Solved_Class_3;
//[백준]7576 : 토마토 - JAVA(자바)

//<새로 알게된 것>
// 시작점이 여러개 일 때의 bfs 활용

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_토마토_BFS {
    static int M,N;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); //가로  (2<=M<=1,000)
        N = Integer.parseInt(st.nextToken()); //세로  (2<=N<=1,000)
        board = new int[N][M];
        dist = new int[N][M];      //default == false

        q = new LinkedList<Node>();

        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dist[i][j] = 0;
            }
        }



        //bfs 돌리기 (시작점이 여러개인 경우 : 한번에 모든 시작점을 큐에 넣어주고 돌린다.)
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 1){
                    q.offer(new Node(i,j));
                }
            }
        }
        bfs();

        /*  board, dist 변화 확인하고 싶으면 맨 아래 주석 넣기

        */

        //dist 를 통해서 최대 일수 찾아주기
        int max = Integer.MIN_VALUE;
        boolean check = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(max < dist[i][j]) {
                    max = dist[i][j];
                }
                //board 중에 하나라도 0 발견한 것 : bfs에서 못돌아서 토마토가 모두 익지 못한 것
                if(board[i][j] == 0){
                    check = true;
                }
            }
        }
        if(check){
            System.out.println("-1");
        }
        else {
            System.out.println(max);
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Node node = q.poll();
            for (int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx >= N || ny < 0 || ny >= M){   //범위초과
                    continue;
                }
                if(board[nx][ny] != 0 || dist[nx][ny] > 0 ){    //방문한 곳 0이 아닌경우(board) ,
                                                                // 방문한 곳이 이미 들른 곳인경우 (dist)
                    continue;
                }
                dist[nx][ny] = dist[node.x][node.y] + 1;
                board[nx][ny] = 1;
                q.offer(new Node(nx,ny));
            }
        }
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            super();
            this.x = x;
            this.y = y;
        }
    }
}
//        //bfs 돌린 후 출력 확인 (board 변화)
//        System.out.println();
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
//        //출력 확인 (dist 변화)
//        System.out.println();
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//        }
