package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1289_원재의_메모리_복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            String str = br.readLine();
            int N = str.length();

            boolean[] arr = new boolean[N];


            for(int i=0; i<N; i++) {
                if(str.charAt(i) == '0') {
                    arr[i] = false;
                }
                else {
                    arr[i] = true;
                }
            }


            int result = 0;
            boolean bit = false;

            for(int i=0; i<str.length(); i++) {
                if(arr[i] != bit) {
                    bit = !bit;
                    result++;
                }
            }
            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
}
