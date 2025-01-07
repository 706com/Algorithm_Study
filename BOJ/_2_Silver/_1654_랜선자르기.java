package BOJ._2_Silver;

//[250108] 12분

// 2^32 : 21억 int 타입
// 2^64 : long타입

import java.io.*;
import java.util.*;

class _1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 랜선길이 2^31 타입 주의
        long left = 0;
        long right = 0;
        long[] arr = new long[K];

        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,arr[i]);
        }

        while(left<=right){
            long mid = (left + right) / 2;
            int result = 0;

            //right 가 1일때 예외처리
            if(mid == 0){
                break;
            }

            for(int i=0; i<K; i++){
                result += arr[i] / mid;
            }

            if(result < N){
                right = mid -1;
            } else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}



