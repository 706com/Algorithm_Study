package BOJ.fail;
//소요시간 : 45분 (실패 : 구현실패)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] fibo = new int[N+1];

        int[] dp = new int[N+1];

        fibo[0] = 0;
        fibo[1] = 1;
        for(int i=2; i<=N; i++){
            fibo[i] = fibo[i-1] + i;
        }

        int reuslt = N*9;
    }
}
