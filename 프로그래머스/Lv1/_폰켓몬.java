package 프로그래머스.Lv1;
//[프로그래머스] 폰켓몬 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
// 1)iterator 를 사용하여 문제 풀이. Iterator, keySet()
// 2)애초에 hashset 을 사용하여 문제 풀이 ★

//< 새로 알게된 것 >
//HashSet
// add() 추가 , remove(값) 삭제 , size() 사이즈 , contains() 검색
// 하나하나 꺼내오려면 iterator

//< 궁금한 것 >

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size()<=pick) {
            answer = set.size();
        }
        else {
            answer = pick;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};

        _폰켓몬 sol = new _폰켓몬();
        System.out.println(sol.solution(nums));
    }
}

//    public static int solution(int[] nums) {
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        int pick = nums.length/2;
//        int count = 0;
//        int answer = 0;
//
//        for(int x : nums){
//            map.put(x,map.getOrDefault(x,0)+1);
//        }
//
//        Iterator<Integer> it = map.keySet().iterator();
//        while(it.hasNext()){
//            it.next();
//            count++;
//        }
//
//        if(count<=pick){
//            answer = count;
//        }
//        else{
//            answer = pick;
//        }
//
//        return answer;
//    }




