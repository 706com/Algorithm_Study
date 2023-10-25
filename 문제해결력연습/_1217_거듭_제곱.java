package 문제해결력연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//처음엔 간단하게 Math.pow 로 풀었지만, 문제 요구에 따라 재귀로 구현

public class _1217_거듭_제곱 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while(count<10) {
            count = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

//			double result = Math.pow(N, M);
            int result = multiple(N,M,1);

            System.out.printf("#%d %d\n",count,result);

        }
    }
    static int multiple(int N,int M, int mul) {
        if(M==0) {
            return mul;
        }
        return multiple(N, M-1, mul*N);

    }
}
