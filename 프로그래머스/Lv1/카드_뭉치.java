package 프로그래머스.Lv1;

// 소요시간
// [240423] : 8분
// [251028] : 9분

import java.util.*;

public class 카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();

        // 카드 뭉치 넣기
        for(String x : cards1){
            q1.offer(x);
        }
        for(String x : cards2){
            q2.offer(x);
        }

        boolean failFlag = false;
        for(String x : goal){
            if(!q1.isEmpty() && q1.peek().equals(x)){
                q1.poll();
            } else if(!q2.isEmpty() && q2.peek().equals(x)){
                q2.poll();
            } else{
                failFlag = true;
                break;
            }
        }
        if(failFlag){
            return "No";
        }
        return "Yes";
    }
}
