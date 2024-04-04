package 프로그래머스.Lv1;
//[프로그래머스] 완주하지 못한 선수 - JAVA(자바)

//< 알고리즘 유형 >
// 해시

//소요시간 : 6분

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(String x : participant){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for(String x : completion){
            map.put(x,map.getOrDefault(x,0)-1);
        }

        for(String x : map.keySet()){
            if(map.get(x)==1){
                answer = x;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        완주하지_못한_선수 sol = new 완주하지_못한_선수();
        System.out.println(sol.solution(participant,completion));
    }
}
