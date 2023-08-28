package 백준.Silver;
//[백준]11279 : 최대 힙 - JAVA(자바)

//< 나의 알고리즘 >
//priority Queue 사용 : 내림차순이니까 reverse !

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

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
