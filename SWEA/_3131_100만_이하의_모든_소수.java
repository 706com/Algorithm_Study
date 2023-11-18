package SWEA;

//5분 -> 답봄

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3131_100만_이하의_모든_소수 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = (int)Math.pow(10,6);

        boolean[] check = new boolean[N+1];
        check[0] = check [1] =true;

        for(int i=2; i<=Math.sqrt(N); i++){
            if(!check[i]) {
                for (int j = i*i; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }

        for(int i=2; i<=N; i++){
            if(!check[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
