package 프로그래머스.Lv2;

//소요시간
//[240521] : 20분

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
//전체를 구하고, 아무것도 입지 않는경우 -1 을 해준다.

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            hm.put(type,hm.getOrDefault(type,1)+1);
        }
        for(String x : hm.keySet()){
            answer *= hm.get(x);
        }

        return answer-1;
    }
}
