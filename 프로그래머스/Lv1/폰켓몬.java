package 프로그래머스.Lv1;
//[프로그래머스] 폰켓몬 - JAVA(자바)

//소요시간 : 5분

// <HashSet Method>
// add() 추가 , remove(값) 삭제 , size() 사이즈 , contains() 검색

import java.util.HashSet;

class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();

        for(int x : nums){
            hs.add(x);
        }

        if(hs.size()>=nums.length/2){
            answer = nums.length/2;
        }
        else{
            answer = hs.size();
        }
        return answer;
    }
}



