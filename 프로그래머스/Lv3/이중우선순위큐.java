package 프로그래머스.Lv3;
//소요시간
//[240522] : 50분 (실패)
//[240528] : 정답참조 🔍

import java.util.*;

public class 이중우선순위큐 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            for(int i=0; i<operations.length; i++){
                StringTokenizer st = new StringTokenizer(operations[i]);
                String command = st.nextToken();
                Integer num = Integer.parseInt(st.nextToken());

                switch (command){
                    case "I":
                        maxPq.offer(num);
                        minPq.offer(num);
                        break;

                    case "D":
                        if(num==1){
                            if(!maxPq.isEmpty()){
                                int max = maxPq.poll();
                                minPq.remove(max);
                            }
                            break;
                        } else{
                            if(!minPq.isEmpty()){
                                int min = minPq.poll();
                                maxPq.remove(min);
                            }
                            break;
                        }
                }
            }
            if(maxPq.isEmpty()){
                return new int[]{0,0};
            }

            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
            return answer;

        }
    }
}
