package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _1284_수도_요금_경쟁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int result = 0;
            int A,B = 0;
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            A = W * P;

            if(W <= R){
                B = Q;
            }
            else{
                B = Q + S * (W - R);
            }

            result = Math.min(A,B);

            System.out.printf("#%d %d",count,result);
            count++;
        }
    }
}
