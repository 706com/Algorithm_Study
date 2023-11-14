package BOJ._2_Silver;

// < 알고리즘 유형 >
// 브루트포스 (중복조합), dp

// < 풀이 접근 >
// *. n이 11 이하이므로 조합이 가능하다.
// 1. 중복이 가능한 permutation함수를 구현한다. (dfs)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_1_2_3_더하기_완전탐색풀이 {

    static int[] arr = {1, 2, 3};
    static int[] output;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            count = 0;
            int num = Integer.parseInt(br.readLine());
            output = new int[num];
            permutaion(0, 0, num);
            System.out.println(count);
        }
    }

    static void permutaion(int depth, int sum, int N) {

        if(sum>N || depth >N){
            return;
        }
        if (sum == N) {
            count++;
//            for(int i=0; i< depth; i++){
//                System.out.print(output[i]+" ");
//            }
//            System.out.println();
            return;
        }

        for (int i = 0; i < 3; i++) {
//            output[depth] = arr[i];
            permutaion(depth + 1, sum + arr[i], N);
        }

    }
}

