package 프로그래머스.Lv1;
//[프로그래머스] 완주하지 못한 선수 - JAVA(자바)

//< 알고리즘 유형 >
// 해시

// 소요시간
// [240404] : 6분
// [240425] : 5분
// [251030] : 4분

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();

        //참가자 (동명이인 포함)
        for(String name : participant){
            map.put(name,map.getOrDefault(name,0)+1);
        }

        //완주자
        for(String name : completion){
            map.put(name,map.get(name)-1);
        }

        for(String x : map.keySet()){
            if(map.get(x) != 0){
                return x;
            }
        }

        return "";
    }
}
