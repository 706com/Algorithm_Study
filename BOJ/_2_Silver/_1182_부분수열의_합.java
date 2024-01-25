package BOJ._2_Silver;
//[백준]1182 : 부분수열의 합 - JAVA(자바)

//소요시간 : 17분

//풀이 : nC1 ~ nCn 까지 각각 구하기.
// *. 조합은 O(2^n) n = 20이므로 시간복잡도는 무난히 통과!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {

    static int N,S;
    static int[] arr;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            combination(0,0,i,0);
        }
        System.out.println(count);
    }

    static void combination(int start, int depth, int r,int sum){
        if(depth == r){
            //sum 출력
            if(sum == S){
                count++;
            }
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i,depth+1,r,sum+arr[i]);
                visited[i] = false;
            }
        }
    }
}
