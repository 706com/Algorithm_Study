package BOJ._2_Silver;

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

public class _1182_부분수열의_합_완전탐색 {

    static int N;
    static int S;
    static int[] arr;
    static boolean[] visited;
    static int cnt = 0;

    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        output = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            combination(0, 0, i, 0);
        }
        System.out.println(cnt);
    }

    public static void combination(int depth, int start, int r, int sum) {
        if (depth == r) {
            if (sum == S) {
                for (int i = 0; i < depth; i++) {
                    System.out.print(output[i] + " ");
                }
                System.out.println();
                cnt++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth + 1, i + 1, r, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}