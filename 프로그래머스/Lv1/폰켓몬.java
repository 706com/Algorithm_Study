package 프로그래머스.Lv1;
//[프로그래머스] 폰켓몬 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
// 1) HashSet 을 사용하여 문제 풀이

//< 새로 알게된 것 >
// HashSet
// add() 추가 , remove(값) 삭제 , size() 사이즈 , contains() 검색

//< 궁금한 것 >

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;

        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        if(set.size()>=max){
            answer = max;
        }
        else{
            answer = set.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};

        폰켓몬 sol = new 폰켓몬();
        System.out.println(sol.solution(nums));
    }
}



