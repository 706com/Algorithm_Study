package 프로그래머스.Lv2;
// 소요시간 : 6분

import java.util.*;

public class 더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int x : scoville){
                pq.add(x);
            }

            while(true){
                if(pq.peek() >= K){
                    break;
                }
                if(pq.size()<=1){
                    return -1;
                }
                int first = pq.poll();
                int second = pq.poll() * 2;
                int x = first + second;
                pq.add(x);
                answer++;
            }
            return answer;
        }
    }
}
