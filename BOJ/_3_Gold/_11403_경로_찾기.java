package BOJ._3_Gold;

//[250205] 🔍

import java.util.*;
import java.io.*;

public class _11403_경로_찾기 {
    static List<Integer>[] list;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        visited = new int[N][N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int edge = Integer.parseInt(st.nextToken());
                if(edge == 1){
                    list[i].add(j);
                }
            }
        }

//        for(List<Integer> x : list){
//            System.out.println(x);
//        }

        for(int i=0; i<N; i++){
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(visited[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
//        visited[start][start] = 1;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int x : list[num]){
                if(visited[start][x] == 0){
                    q.offer(x);
                    visited[start][x] = 1;
                }
            }
        }
    }
}
