package BOJ._1_Bronze;
//[백준]11050 : 이항 계수 1 - JAVA(자바)

//<새로 알게된 것>
//(n r) = nCr = n! / r!(n-r)!
//즉 nCr 의 공식(유도법)을 알고있으면 됨!

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = factorial(N) / (factorial(K) * factorial(N-K)) ;

        System.out.println(result);
    }

    public static int factorial(int num){
        if(num == 0){
            return 1;
        }
        else {
            return num * factorial(num-1);
        }
    }
}
