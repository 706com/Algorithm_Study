package BOJ._2_Silver;
//[백준]2667 : 단지번호붙이기 - JAVA(자바)

//소요시간 : 7분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2667_단지번호붙이기 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j) -'0';
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    list.add(bfs(i,j));
                    count++;
                }
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for(int x : list){
            System.out.println(x);
        }
    }
    static int bfs(int x, int y){
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }
                if(arr[nx][ny] != 1 || visited[nx][ny]){
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
