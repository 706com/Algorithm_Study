package BOJ._2_Silver;

// 소요시간 : 6분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15656_N과_M_7 {
    static int N;
    static int[] arr,output;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0,M);
        System.out.println(sb);
    }
    static void dfs(int start , int depth,int r){
        if(depth == r){
            for(int i=0; i<depth; i++){
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            output[depth] = arr[i];
            dfs(i,depth+1,r);
        }
    }
}
