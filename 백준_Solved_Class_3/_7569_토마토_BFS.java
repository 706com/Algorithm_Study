package 백준_Solved_Class_3;
//[백준]7569 : 토마토 - JAVA(자바)

//< 나의 알고리즘 >
// bfs를 이용해서 풀어보려 한다. 다만, H가 주어졌으니 dz 까지 활용해서 하려 하는데
// bfs 과정이 머릿속으로 완벽정리가 되지 않아서 그런지, 어떻게 해야할 지 헷갈리는 것 같다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토_BFS {
    static int M,N,H;
    static int[][][] board;
    static int[][][] dist;

    static Queue<Node> q;

    static int[] dx = {0,0,-1,1,0,0};   //상 하 좌 우 up down
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());   //가로    2 ≤ M ≤ 100
        N = Integer.parseInt(st.nextToken());   //세로    2 ≤ N ≤ 100
        H = Integer.parseInt(st.nextToken());   //높이    1 ≤ H ≤ 100

        board = new int[H][N][M];
        dist = new int[H][N][M];

        boolean check = false;

        //입력
        for(int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k] == 0){
                        check = true;
                    }
                }
            }
        }

        if(!check){
            System.out.println("0");
            return;
        }

        //bfs 탐색하기
        for(int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(board[i][j][k] == 1 && dist[i][j][k] == 0) {
                        bfs(i, j, k);
                    }
                }
            }
        }

        System.out.println();

        //bfs 후 board 보기
        for(int i=0; i<H; i++) {
            System.out.println("board "+ i + "층");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(board[i][j][k]+" ");
                }
                System.out.println();
            }
        }
        System.out.println();

        //bfs 후 dist 보기
        for(int i=0; i<H; i++) {
            System.out.println("dist " + i + "층");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(dist[i][j][k]+" ");
                }
                System.out.println();
            }
        }


        int result = 0;
        for(int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //dist 최댓값 담기
                    if(result < dist[i][j][k]){
                        result = dist[i][j][k];
                    }
                    //하나라도 익지않은 토마토가 있다면 -1 출력
                    if(board[i][j][k] == 0){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        //result 값 (dist의 최댓값) 이 1이라면 (bfs를 돌면서 전파시키게 없다면) 0출력
        System.out.println(result);

    }

    static void bfs(int z,int y,int x){
        int day = 0;
        dist[z][y][x] = day;

        q= new LinkedList<>();
        q.offer(new Node(x,y,z,day));

        while(!q.isEmpty()){
            Node node = q.poll();
            day = node.day+1;
            for(int i=0; i<6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx<0 || ny<0 || nz<0 || nx>=M || ny>=N || nz>=H){
                    continue;
                }
                if(board[nz][ny][nx] != 0 || dist[nz][ny][nx] != 0){ //접근한 토마토가 0이 아니거나, 이미 방문한 곳
                    continue;
                }

                q.offer(new Node(nx,ny,nz,day));
                board[nz][ny][nx] = 1;
                dist[nz][ny][nx] = day;
            }
        }
    }

    static class Node{
        int x;
        int y;
        int z;
        int day;

        Node(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}
