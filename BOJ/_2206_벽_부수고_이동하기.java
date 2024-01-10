package BOJ;

//소요시간 : 50분(실패 - 시간초과)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_벽_부수고_이동하기 {
    static int N,M;
    static int[][] arr;
    static int[][] dist;
//    static boolean possible = false;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = str.charAt(j-1)-'0';
            }
        }

        if(N==1 && M==1){
            System.out.println("1");
            return;
        }

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                //부술 벽의 위치 담기
                if(arr[i][j] == 1) {
//                    possible = false;
                    dist = new int[N+1][M+1];
                    int num = bfs(i,j);
                    if(num != -1) {
                        min = Math.min(min, num);
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println("-1");
            return;
        }

        System.out.println(min);
    }
    static int bfs(int wx, int wy){
        Queue<Node> q = new LinkedList<>();
        // 1,1 출발
        q.offer(new Node(1,1));
        dist[1][1] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //도착 지점
                if(nx==N && ny== M){
//                    possible = true;
                    return dist[node.x][node.y]+1;
                }
                //부술 벽 예외적 허용
                if(nx == wx && ny == wy){
                    q.offer(new Node(nx,ny));
                    dist[nx][ny] = dist[node.x][node.y] + 1;
                    continue;
                }
                if(nx<1 || nx>N || ny<1 || ny>M){
                    continue;
                }
                if(arr[nx][ny] == 1 || dist[nx][ny] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] + 1;
            }
        }
        return -1;
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
