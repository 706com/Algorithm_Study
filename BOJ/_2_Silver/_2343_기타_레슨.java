package BOJ._2_Silver;

//[250113] 🔍

import java.util.*;
import java.io.*;

public class _2343_기타_레슨 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,arr[i]);
            right += arr[i];
        }
        while(left<=right){
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1;
            for(int i=0; i<N; i++){
                // 합이 블루레이 양 이내
                if(sum + arr[i] <= mid){
                    sum += arr[i];
                }
                // 합이 블루레이 양을 넘어선 순간 다음 블루레이로
                else{
                    count++;
                    sum = arr[i];
                }
            }

            // 필요한 블루레이 양이 주어진 값보다 많으면 블루레이 크기를 늘려야함
            if(count>M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(left);   //최솟값 찾아야 하니 left
    }
}
