package 프로그래머스.Lv1;
//[프로그래머스] 완주하지 못한 선수 - JAVA(자바)

//< 알고리즘 유형 >
// 해시

// 소요시간
// [240404] : 6분
// [240425] : 5분

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        for(String x : participant){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        for(String x : completion){
            hm.put(x,hm.getOrDefault(x,0)-1);
        }

        for(String result : hm.keySet()){
            if(hm.get(result) == 1){
                return result;
            }
        }

        return "";
    }
    public static void main(String[] args){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        완주하지_못한_선수 sol = new 완주하지_못한_선수();
        System.out.println(sol.solution(participant,completion));
    }
}
