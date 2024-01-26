package BOJ._2_Silver;

// 소요시간 : 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _15654_N과_M_5 {
    static int N;
    static List<Integer> list;
    static int[] output;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        output = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        dfs(0,0,M);
        System.out.println(sb);
    }
    static void dfs(int start, int depth,int r){
        if(depth == r){
            //output 출력
            for(int i=0; i<depth; i++){
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            output[depth] = list.get(i);
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1,r);
                visited[i] = false;
            }
        }
    }
}
