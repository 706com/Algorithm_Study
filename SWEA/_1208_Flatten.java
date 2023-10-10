package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class _1208_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int count = 1;

        while(count<=T){
            int N = Integer.parseInt(br.readLine());
            int result;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            int[] arr = new int[len];

            for(int i=0; i<len; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for(int i=0; i<N; i++){
                arr[len-1]--;
                arr[0]++;
                Arrays.sort(arr);
            }

            result = arr[len-1] - arr[0];

            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
}
