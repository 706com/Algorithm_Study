package BOJ._3_Gold;

//[250210] 🔍📌

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4485_녹색_옷_입은_애가_젤다지 {
    static int N;
    static int[][] arr;
    static int[][] dist;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = null;
        int idx = 1;
        while(!(n = br.readLine()).equals("0")) {
            N = Integer.parseInt(n);
            arr = new int[N][N];
            dist = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(dist[i],Integer.MAX_VALUE);
            }

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(0, 0);
//            System.out.println(Arrays.deepToString(arr));
//            System.out.println(Arrays.deepToString(dist));
            sb.append("Problem "+idx+": "+dist[N-1][N-1]+"\n");
            idx++;
        }
        System.out.println(sb);
    }
    public static void bfs(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)-> o1.cost - o2.cost);
        pq.offer(new Node(x,y,arr[x][y]));
        dist[x][y] = arr[x][y];

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.cost > dist[node.x][node.y]){
                continue;
            }

            if(node.x == N-1 && node.y == N-1){
                return;
            }
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }

//                if(dist[nx][ny] < node.cost + arr[nx][ny]){
//                    continue;
//                }
                if(node.cost+arr[nx][ny] < dist[nx][ny]) {
                    pq.offer(new Node(nx, ny, node.cost + arr[nx][ny]));
                    dist[nx][ny] = node.cost + arr[nx][ny];
                }
            }
        }
    }
    public static class Node{
        int x;
        int y;
        int cost;
        Node (int x, int y, int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
}
