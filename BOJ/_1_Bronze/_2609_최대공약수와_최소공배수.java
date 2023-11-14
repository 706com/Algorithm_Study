package BOJ._1_Bronze;

//[백준]2609 : 최대공약수와 최대공배수 - JAVA(자바)
//새로 알게된 것
//GCD (Greatest Common Divisor) algorithm : 유클리드 호제법
//LCM (Least Common Multiple) : a * b / gcd

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = GCD(A,B);
        int lcm = LCM(A,B);
        System.out.println(gcd);
        System.out.println(lcm);
    }

    //GCD (Greatest Common Divisor) : 유클리드 호제법 알고리즘
    public static int GCD(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //LCM(Least Common Multiple) : A * B / 최대공약수
    public static int LCM(int a, int b){
        return a * b / GCD(a,b);
    }
}
