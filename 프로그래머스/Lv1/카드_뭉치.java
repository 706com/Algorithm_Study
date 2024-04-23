package 프로그래머스.Lv1;

// 소요시간
// [240423] : 8분

import java.util.*;

public class 카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        // 큐에 카드뭉치들 넣기. (순서)
        for(int i=0; i<cards1.length; i++){
            q1.offer(cards1[i]);
        }
        for(int i=0; i<cards2.length; i++){
            q2.offer(cards2[i]);
        }

        //탐색하며 결과 반환
        for(int i=0; i<goal.length; i++){
            String key = goal[i];
            if(!q1.isEmpty() && key.equals(q1.peek())){
                q1.poll();
                continue;
            } else if(!q2.isEmpty() && key.equals(q2.peek())){
                q2.poll();
            } else{
                return "No";
            }
        }
        return "Yes";
    }
}
