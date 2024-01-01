package BOJ._3_Gold;
//[백준]7576 : 토마토 - JAVA(자바)

//소요시간 : 49분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_토마토 {
    static int N,M;
    static int[][] arr;
    static int[][] dist;

    static Queue<Node> q = new LinkedList<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //미리 q에 다 넣어주고 방문처리
                if(arr[i][j] == 1 && dist[i][j] == 0){
                    q.offer(new Node(i,j));
                    dist[i][j] = 1;
                }
            }
        }
        bfs();

//// dist 확인
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//        }

        int max = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 토마토가 익지 못하는 상황 (토마토가 없는게아닌데 거리가 0)
                if(arr[i][j] != -1 && dist[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max,dist[i][j]);
            }
        }
        System.out.println(max-1);
    }
    static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                if(arr[nx][ny] != 0 || dist[nx][ny] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] + 1;
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
