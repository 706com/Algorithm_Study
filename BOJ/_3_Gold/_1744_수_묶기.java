package BOJ._3_Gold;

// < 알고리즘 유형 >
// 그리디

//소요시간 : 40분(실패 : 반례실패)
//소요시간 : 20분
//[250306] : 15분

// < 풀이 방법 >
// 음수, 0, 양수 로 나눠서 풀이


import java.io.*;
import java.util.*;

public class _1744_수_묶기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minusPq = new PriorityQueue();
        PriorityQueue<Integer> plusPq = new PriorityQueue(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0){
                minusPq.offer(num);
            } else{
                plusPq.offer(num);
            }
        }

        // 양수 처리
        long result = 0;
        while(plusPq.size() > 1){
            int first = plusPq.poll();
            int second = plusPq.peek();

            // 더한 것 보다 곱한게 클 경우 (1이 없을 경우)
            if(first * second > first + second){
                result += first * plusPq.poll();
            }
            else{
                result += first;
            }
        }
        if(!plusPq.isEmpty()){
            result += plusPq.poll();
        }

        // 음수 처리
        while(minusPq.size() > 1){
            result += (minusPq.poll() * minusPq.poll());
        }
        if(!minusPq.isEmpty()){
            result += minusPq.poll();
        }
        System.out.println(result);
    }
}
