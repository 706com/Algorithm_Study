package BOJ;

import java.io.*;
import java.util.*;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            if(Arrays.binarySearch(arr,arr2[i])>=0){
                sb.append('1').append('\n');
            }else{
                sb.append('0').append('\n');
            }
        }
        System.out.println(sb);
    }
}
