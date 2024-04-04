package 프로그래머스.Lv2;
//[프로그래머스] 전화번호 목록 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//소요시간 : 26분 🔍📌

//< 알고리즘 풀이 >
// 1. 해쉬에 전화번호 담기.
// 2. 각 전화번호의 substring 으로 해쉬에서 접두어 찾기.
// 3. 접두어 있으면 false 없으면 true 리턴

import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String,Integer> map = new HashMap<>();

        for(String x : phone_book){
            map.put(x,1);
        }
        for(String x : map.keySet()){
            for(int i=1; i<x.length(); i++){
                String subStr = x.substring(0,i);
                if(map.containsKey(subStr)){
                    answer = false;
                    break;
                }
            }
            if(!answer){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //String[] phone_book = {"119", "97674223", "1195524421"};
        //String[] phone_book = {"123","456","789"};
        String[] phone_book = {"12","123","1235","567","88"};

        전화번호_목록 sol = new 전화번호_목록();
        System.out.println(sol.solution(phone_book));
    }
}
