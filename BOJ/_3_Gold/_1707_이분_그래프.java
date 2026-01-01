package BOJ._3_Gold;

//[251227] 1시간 30분

import java.util.*;
import java.io.*;

public class _1707_이분_그래프 {
    static int[] color;
    static List<Integer>[] graph;
    static int V,E;
    static boolean endFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            endFlag = false;

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
                // 무방향 그래프
                graph[start].add(end);
                graph[end].add(start);
            }
            for(int i=1; i<=V; i++){

                //미방문이면 시작
                if(color[i] == -1){
                    color[i] = 0;   // 0부터 시작
                    dfs(i);
                    if(endFlag){
                        System.out.println("NO");
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(color));
            if(!endFlag){
                System.out.println("YES");
            };
        }
    }
    public static void dfs(int start){
        if(endFlag){
            return;
        }
        for(int x : graph[start]){
            // 이미 방문한 곳의 컬러가 현재와 같으면 이분그래프 X
            if(color[x] == color[start]){
                endFlag = true;
                return;
            }
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
