package BOJ._3_Gold;

//[251222] 8:47

import java.util.*;
import java.io.*;

public class _1707_이분_그래프 {
    static int[] color;
    static List<Integer>[] graph;
    static int V,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            color = new int[V+1];
            Arrays.fill(color, -1);
            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=1; i<=E; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end); // 미방문 초기화
            }
            for(int i=1; i<=V; i++){

                //미방문이면 시작
                if(color[i] == -1){
                    dfs(i);   //0부터 시작
                }
            }
        }
    }
    public static void dfs(int start){
        color[start] = 0;   // 0부터 시작

        for(int x : graph[start]){
            // 이미 방문했으면 스킵
            if(color[x] != -1){
                continue;
            }
            if(color[start] == 0){
                color[x] = 1;
            } else if(color[start] == 1){
                color[x] = 0;
            }
            dfs(x);
        }
    }
}
