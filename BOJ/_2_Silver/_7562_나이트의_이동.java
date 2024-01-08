package BOJ._2_Silver;

//소요시간 : 24분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_나이트의_이동 {
    static int N;
    static int N1,M1,N2,M2;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-2,-1,1,2,-2,-1,1,2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            N1 = Integer.parseInt(st.nextToken());
            M1 = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            dist = new int[N][N];

            st = new StringTokenizer(br.readLine());
            N2 = Integer.parseInt(st.nextToken());
            M2 = Integer.parseInt(st.nextToken());

            //위치가 같을땐 사전처리
            if(N1==N2 && M1==M2){
                System.out.println("0");
                continue;
            }
            bfs();
        }
    }
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N1,M1));
        dist[N1][M1] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<8; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx == N2 && ny == M2){
                    System.out.println(dist[node.x][node.y]);
                    return;
                }
                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }
                if(dist[nx][ny]!=0){
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

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
