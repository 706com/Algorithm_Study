package 문제해결력연습;

// < 알고리즘 유형 >
// 완전탐색(백트래킹)

// < 풀이 접근 >
// *. 순서 상관없고, 중복이 허용되지 않는 조합.
// *. 조합은 O(2^n) n = 20이므로 시간복잡도는 무난히 통과!
// 1. combination (중복x, 순서x) 함수를 구현한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {

    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int count = 0;
    static int N;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        st= new StringTokenizer(br.readLine()," ");
        for(int i=0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0,0,0);
    }

    static void combination(int depth, int start, int sum){

        if(depth>N){
            return;
        }
        if(sum == S){
            count++;
            for(int i=0; i<depth; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
//            System.out.println(count);
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth + 1, i+1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}
