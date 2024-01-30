package BOJ._2_Silver;

//소요시간 : 50분 (실패 : 문제이해를 잘못함..OMG)
//소요시간 : 5분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_로또 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr,output;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0){
                break;
            }
            N = st.countTokens();
            arr = new int[N];
            output = new int[N];
            visited = new boolean[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0,6);

            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int start, int depth, int r){
        if(depth == r){
            for(int i=0; i<depth; i++){
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<N; i++){
            output[depth] = arr[i];
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1,r);
                visited[i] = false;
            }
        }
    }
}
