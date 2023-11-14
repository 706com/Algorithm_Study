package BOJ._1_Bronze;

// < 알고리즘 유형 >
// 브루트포스 (중복순열)

// < 풀이 접근 >
// 1. 삼각수 점화식(공식)을 활용해 1000이 되는 곳까지 배열을 생성한다. (1000이 되는 n이 무엇인지 생각하기) n == 45
// 2. n이 45 밖에 안된다는 것이 확인 되었으니 브루트포스 가능.
// 3. permutation 을 구현하여 탐색.  (3중포문도 가능)
// 4. 중복이 허용되므로 visited 배열은 삭제.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10448_유레카_이론 {

    static int[] arr;
    static int[] output = new int[3];
    static StringBuilder sb = new StringBuilder();
    static boolean available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n = 45;

        arr = new int[n];
        for(int i=1; i<=45; i++){
            arr[i-1] = i*(i+1)/2;
        }

        for(int i=0; i<T; i++){
            int answer = Integer.parseInt(br.readLine());
            permutation(answer,0,n,3);
            if(!available){
                sb.append("0").append('\n');
            }
            available = false;
        }
        System.out.println(sb);
    }

    public static void permutation(int answer, int depth, int n, int r){
        if(depth == r){
            int sum = 0;
            for(int i=0; i<r; i++){
                sum += output[i];
            }
            if(sum == answer){
                sb.append("1").append('\n');
                available = true;
            }
            return;
        }

        for(int i=0; i<n; i++){
            output[depth] = arr[i];
            permutation(answer,depth+1,n,r);
            if(available){
                return;
            }
        }
    }
}
