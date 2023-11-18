package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
//< 풀이 접근 >
//*. 순서 상관없고, 중복이 허용되지 않는 조합.
//*. 조합은 O(2^n) n = 20이므로 시간복잡도는 무난히 통과!
//1. combination (중복x, 순서x) 함수를 구현한다.

public class _2817_부분_수열의_합 {

    static int N,K;
    static int[] arr;
    static boolean[] visited;
    static int[] output;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = 0;

            arr = new int[N];
            output = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) {
                dfs(0,0, 0,i);
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
    public static void dfs(int start ,int depth,int sum,int r){
        if(depth == r) {
            if (sum == K) {
//                for(int i=0; i<depth; i++){
//                    System.out.print(output[i]+" ");
//                }
//                System.out.println();
                result++;
            }
            return;
        }

        if(depth==N || sum > K){
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                dfs(i,depth+1, sum+arr[i],r);
                visited[i] = false;
            }
        }
    }
}
