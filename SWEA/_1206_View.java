package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1206_View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while(T<=10) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;

            for(int i=2; i<N-2; i++) {
                if(arr[i]>arr[i-1] && arr[i]>arr[i-2] && arr[i]>arr[i+1] && arr[i]>arr[i+2]) {
                    int left = Math.min(arr[i]-arr[i-1],arr[i]-arr[i-2]);
                    int right = Math.min(arr[i]-arr[i+1],arr[i]-arr[i+2]);
                    result += Math.min(left,right);
                }
            }

            System.out.printf("#%d %d\n",T,result);
            T++;
        }
    }
}
