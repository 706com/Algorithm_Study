package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3307_최장_증가_부분_수열 {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] lis = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lis[0] = arr[0];
            int len = 1;
            for(int i=1; i<N; i++) {
                int key = arr[i];

                if(lis[len-1]<key) {
                    len++;
                    lis[len-1] = key;
                }
                else {
                    int low = 0;
                    int high = len-1;

                    while(low<high) {
                        int mid = (low + high) /2;

                        if(lis[mid]<key) {
                            low = mid+1;
                        }
                        else {
                            high = mid;
                        }
                    }
                    lis[low] = key;
                }
            }

            System.out.printf("#%d %d\n",count,len);
            count++;
        }
    }

}
