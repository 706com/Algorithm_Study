package 프로그래머스.Lv2;

// 소요시간
// [240426] : 40분
// [240624] : 40분
// [250107] : 20분
// [251116] : 28분

import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String,Integer> cart = new HashMap<>();

        //최초 9일 담기
        for(int i=0; i<9; i++){
            cart.put(discount[i],cart.getOrDefault(discount[i],0)+1);
        }

        //10일차부터 확인 시작
        for(int i=9; i<discount.length; i++){
            //11일차 부터는 일 수 지난 상품은 제외
            if(i != 9){
                cart.put(discount[i-10],cart.getOrDefault(discount[i-10],0)-1);
            }
            cart.put(discount[i],cart.getOrDefault(discount[i],0)+1);

            if(checkAllSales(want,number,cart)){
                answer++;
            }
        }

        // for(String x : cart.keySet()){
        //     System.out.println(x +" "+ cart.get(x));
        // }
        return answer;
    }
    boolean checkAllSales(String[] want,int[] number, Map<String,Integer> cart){
        System.out.println();
        for(int i=0; i<want.length; i++){
            //하나라도 갯수가 모자라면 false 리턴
            if(cart.containsKey(want[i]) && cart.get(want[i]) != number[i]){
                return false;
            }
            if(!cart.containsKey(want[i])){
                return false;
            }
        }
        return true;
    }
}
