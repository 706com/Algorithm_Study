package BOJ._1_Bronze;

//소요시간 : 5분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2577_숫자의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String num = String.valueOf(A*B*C);

        int[] arr = new int[10];

        for(int i=0; i<num.length(); i++){
            arr[num.charAt(i)-'0']++;
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
