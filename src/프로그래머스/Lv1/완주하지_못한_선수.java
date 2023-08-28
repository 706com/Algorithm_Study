package 프로그래머스.Lv1;
//[프로그래머스] 완주하지 못한 선수 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
// 1. 선수들을 모두 해쉬에 담기. (value +1)
// 2. 완주한 선수들을 해쉬에서 찾기. (value -1)
// 3. 완주하지 못한 선수 (해쉬 value가 1인 선수 리턴)

//< 새로 알게된 것 >
// hashMap.keySet()
// 키들을 하나씩 꺼내와서 배열형태로 저장

//< 궁금한 것 >

import java.util.HashMap;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        String answer = "";

        //참가자 명단 넣기
        //동명이인 일 경우, 같은 이름을 가진 key 에 +1
        for(int i=0; i<participant.length; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }

        //완주자 찾기
        //카운트 하나씩 빼주기
        for(int i=0; i<completion.length; i++){
            map.put(completion[i],map.get(completion[i])-1);
        }

        //hash에 담겨있는 값 증 1 찾기
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
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
