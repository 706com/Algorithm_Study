package BOJ._2_Silver;
//[백준]15650 : N과 M(2) - JAVA(자바)

// 소요시간 : 9분

// 풀이
// nCr 을 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_N과_M_2 {
    static int N,M;
    static int[] arr,output;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        for(int i=1; i<=N; i++){
            arr[i-1] = i;
        }

        dfs(0,0,M);
    }
    static void dfs(int start,int depth, int r){
        if(depth == r){
            //output 출력
            for(int i=0; i<depth; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
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
