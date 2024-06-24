package 프로그래머스.Lv2;

// 소요시간
// [240426] : 40분
// [240624] : 40분

import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        //최초 10개
        for(int i=0; i<10; i++){
            hm.put(discount[i],hm.getOrDefault(discount[i],0)+1);
        }

        boolean isSale = true;
        for(int i=0; i<want.length; i++){
            // 하나라도 불일치하면 탈출
            if(!hm.containsKey(want[i]) || hm.get(want[i]) != number[i]){
                isSale = false;
                break;
            }
        }
        if(isSale){
            answer++;
        }

        //11번째부터 조회
        for(int i=10; i<discount.length; i++){
            isSale = true;
            // 새로운 날짜 할인 품목 추가
            hm.put(discount[i],hm.getOrDefault(discount[i],0)+1);
            // 10일 전 할인 품목 제거
            hm.put(discount[i-10],hm.getOrDefault(discount[i-10],0)-1);
            for(int j=0; j<want.length; j++){
                //📌 값이 존재하지 않거나, 하나라도 불일치하면 탈출
                if(!hm.containsKey(want[j]) || hm.get(want[j]) != number[j]){
                    isSale = false;
                    break;
                }
            }
            if(isSale){
                answer++;
            }
        }
        return answer;
    }
}
