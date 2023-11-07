package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹 (아오 헷갈려)
//< 풀이 접근 >
//*. 순서 상관없고, 중복이 허용되지 않는 조합.
//*. 조합은 O(2^n) n = 20이므로 시간복잡도는 무난히 통과!
//1. combination (중복x, 순서x) 함수를 구현한다.

/*
 * <결과> (배열 인덱스 탐색 과정)
 * 0
 * 01
 * 02
 * 023
 * 03
 * 12
 * 13
 * 23
 * 3
*/

public class _2817_부분_수열의_합 {

    static int N,K;
    static int[] arr;
    static boolean[] visited;
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
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            System.out.printf("#%d %d",count,result);
            count++;
        }
    }
    public static void dfs(int depth,int sum){
        if(sum == K){
            result++;
            return;
        }

        if(depth==N || sum > K){
            return;
        }
        for(int i=depth; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, sum+arr[i]);
                visited[i] = false;
            }
        }
    }
}
