package BOJ._2_Silver;
//[백준]11279 : 최대 힙 - JAVA(자바)

// < 알고리즘 유형 >
// 자료구조, 우선순위큐

// < 풀이 접근 >
// 1. priorityQueue 를 선언한다. ( 자바는 최소힙이 디폴트값 이므로 reverseOrder() 를 해준다.)
// 2. 0을 기준으로 출력을 판별한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11279_최대_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append('\n');
                }else{
                    sb.append("0").append('\n');
                }
            }
            else{
                pq.offer(num);
            }
        }
        System.out.println(sb);
    }
}
