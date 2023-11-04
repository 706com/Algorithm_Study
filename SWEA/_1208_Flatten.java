package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class _1208_Flatten {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;

        while(T<=10) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            while(N-->0) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            int result = arr[99]-arr[0];

            System.out.printf("#%d %d\n",T,result);
            T++;
        }
    }
}
