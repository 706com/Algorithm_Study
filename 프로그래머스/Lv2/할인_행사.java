package 프로그래머스.Lv2;

// 소요시간
// [240426] : 40분

import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 행사 물품을 담는 해시맵을 생성한다.
        HashMap<String, Integer> hm = new HashMap<>();
        int day = 0;
        while(day != discount.length){
            boolean isTrue = true;

            //해당 일차의 할인 품목 담는다.
            hm.put(discount[day],hm.getOrDefault(discount[day],0)+1);
            //만일 10일이 넘어가면 day-10의 품목은 감소시킨다.(제거)
            if(day>=10){
                hm.put(discount[day-10],hm.getOrDefault(discount[day-10],0)-1);
            }
            day++;
//             System.out.println("day : " + day);
//             for(String x : hm.keySet()){
//                 System.out.println(" key : " + x + " = " + hm.get(x));
//             }

            // 구매를 원하는 품목의 갯수를 보면서 result를 증가시킨다.
            for(int i=0; i<want.length; i++){
                //해당 품목이 없으면 탈출
                if(!hm.containsKey(want[i])){
                    isTrue = false;
                    break;
                }
                //하나라도 갯수가 안되면 탈출
                if(hm.get(want[i]) < number[i]){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                answer++;
            }
        }

        return answer;
    }
}
