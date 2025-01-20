package BOJ._3_Gold;

//[250121] 🔍

import java.util.*;
import java.io.*;

public class _1300_K번째_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine()); // 최대 구구단 행 : 10^9 (10억)


        long left = 1;
        long right = k;
        // mid => x 를 찾기
        // mid ( x ) 를 기준으로 작은 값의 갯수가 k가 되어야 함
        while(left<=right){
            long mid = (left + right) / 2 ;
            long count = 0;

            // 구구단처럼 생각했을 때, 구구단 각 행이 x 보다 작은 값 갯수 = x / i
            // + mid 기준으로 작은 값 계산할 때, 최대 갯수가 N의 크기(행 크기)를 벗어나는 상황은 방지 해야함
            for(int i=1; i<=N; i++){
//                count += (mid / i);
                count += Math.min(mid/i , N);   // 행 벗어났을 때의 최댓값 조정
            }

//            if(count == k){
//                System.out.println(mid);
//                return;
//            }
            if (count < k){
                left = mid + 1;     //같을 때 종료하면 왜 안되고 범위를 조정시키는지 아직 의문
            }else{
//                right = mid - 1;
                right = mid - 1;    //중복 값이 존재
            }
        }
        System.out.println(left);
    }
}
