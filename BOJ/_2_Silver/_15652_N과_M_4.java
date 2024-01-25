package BOJ._2_Silver;

//소요시간 : 6분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652_N과_M_4 {
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
        for(int i=1; i<=N; i++){
            arr[i-1] = i;
        }

        dfs(0,0,M);
        System.out.println(sb);
    }
    static void dfs(int start, int depth, int r){
        if(depth == r){
            //output 출력
            for(int i=0; i<depth; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<N; i++){
            output[depth] = arr[i];
            dfs(i,depth+1,r);
        }
    }
}
