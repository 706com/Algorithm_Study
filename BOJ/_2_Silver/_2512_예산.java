package BOJ._2_Silver;

//[250110] 3:00 ~

import java.io.*;
import java.util.*;

public class _2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right,arr[i]);
        }

        int maximum = Integer.parseInt(br.readLine());

        while(left<=right){
            int mid = (left + right) / 2;
            long sum = 0;

            for(int i=0; i<N; i++){
                sum += Math.min(mid,arr[i]);
            }

            if(sum<=maximum){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
