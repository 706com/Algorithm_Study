package 프로그래머스.Lv2;

// 소요시간
// [240426] : 40분
// [240624] : 40분
// [250107] : 20분

import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wanted = new HashMap<>();
        Map<String, Integer> sales = new HashMap<>();

        // 원하는 상품, 수량 기록
        for(int i=0; i<want.length; i++){
            wanted.put(want[i],number[i]);
        }

        //10일째까지 미리 담기
        for(int i=0; i<9; i++){
            sales.put(discount[i],sales.getOrDefault(discount[i],0)+1);
        }

        // for(String x : sales.keySet()){
        //     System.out.println(x+" "+ sales.get(x));
        // }

        //10일차부터 확인
        for(int i=9; i<discount.length; i++){
            sales.put(discount[i],sales.getOrDefault(discount[i],0)+1);
            // 11일차부턴 1일차꺼 빼기
            if(i>=10){
                sales.put(discount[i-10],sales.getOrDefault(discount[i-10],0)-1);
            }

            //10일째부터 비교 시작
            boolean flag  = true;
            for(String x : wanted.keySet()){
                if(sales.get(x) != wanted.get(x)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }

        return answer;
    }
}
