package BOJ._3_Gold;
//[백준]7569 : 토마토 - JAVA(자바)

//소요시간 : 17분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토 {
    static Queue<Node> q = new LinkedList<>();
    static int M,N,H;
    static int[][][] arr;
    static int[][][] dist;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        dist = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    //미리 큐에 토마토 담아주기
                    if(arr[i][j][k]==1){
                        q.offer(new Node(i,j,k));
                        dist[i][j][k] = 1;
                    }
                }
            }
        }
        bfs();

        int max = 0;
        //dist 확인
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    // 토마토가 있는데, 익지 못하는 경우 == -1 출력
                    if(arr[i][j][k] != -1 && dist[i][j][k] == 0){
                        System.out.println("-1");
                        return;
                    }
                    max = Math.max(max,dist[i][j][k]);
                }
            }
        }
        // dist의 최댓값 출력
        System.out.println(max-1);
    }
    static void bfs(){
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx<0 || ny<0 || nz<0 || nx>=H || ny>=N || nz>=M){
                    continue;
                }
                if(arr[nx][ny][nz] != 0 || dist[nx][ny][nz] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny,nz));
                dist[nx][ny][nz] = dist[node.x][node.y][node.z] + 1;
            }
        }
    }
    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
