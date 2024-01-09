package BOJ;

//소요시간 : 33분 (초반 N,M,x,y 생각을 쓸데없이 너무 오래한 듯)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2583_영역_구하기 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //N == x
        M = Integer.parseInt(st.nextToken());   //M == y
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=y1; j<y2; j++){
                for(int k=x1; k<x2; k++){
                    arr[j][k] = 1;
                    visited[j][k] = true;
                }
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(list);
        System.out.println(count);
        for(int x : list){
            System.out.print(x+" ");
        }
    }
    static int bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                if(arr[nx][ny] != 0 || visited[nx][ny]){
                    continue;
                }
                q.offer(new Node(nx,ny));
                visited[nx][ny] = true;
                count++;
            }
        }
        return count;
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
