package BOJ._2_Silver;
//[백준]1932 : 연속합 - JAVA(자바)

//소요시간 : 20분

//풀이방법 : 앞에서부터 보는게 아닌, 오히려 뒤에서부터 dp를 타서 가장 최댓값을 저장시켜놓는다.
// -> 꼭 뒤에서부터 안봐도 되고, 본인과 그동안 누적값이랑 비교해가면서 나가도됨
/*
    for(int i=1; i<N; i++){
        dp[i] = Math.max(dp[i-1]+arr[i] ,arr[i]);
    }
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[N-1] = arr[N-1];
        for(int i=N-2; i>=0; i--){
            dp[i] = Math.max(arr[i], dp[i+1]+arr[i]);
        }
//        System.out.println(Arrays.toString(dp));
        int max = Integer.MIN_VALUE;
        for(int x : dp){
            max = Math.max(max,x);
        }
        System.out.println(max);
    }
}
