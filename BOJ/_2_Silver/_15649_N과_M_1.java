package BOJ._2_Silver;

//소요 시간 : 11분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_N과_M_1 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        for(int i=1; i<=N; i++){
            arr[i-1] = i;
        }
        combination(0,0,N,M);
        System.out.println(sb);
    }

    static void combination(int start, int depth, int N,int r){
        if(depth == r){
            for(int i=0; i<depth; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            output[depth] = arr[i];
            if(!visited[i]){
                visited[i] = true;
                combination(i+1,depth+1,N,r);
                visited[i] = false;
            }
        }
    }
}
