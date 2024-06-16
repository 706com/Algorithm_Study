package 프로그래머스.Lv1;

//소요시간
//[240617] : 9분

import java.util.*;

public class 명예의_전당 {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<score.length; i++){
            list.add(score[i]);
            Collections.sort(list);
            if(list.size() == k+1){
                list.remove(0);
            }
            answer.add(list.get(0));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
