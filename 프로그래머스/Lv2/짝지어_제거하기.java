package 프로그래머스.Lv2;

//소요시간 : 15분 🔍
//소요시간 : 5분
//[251017] 7분

import java.util.*;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;

            Deque<Character> stk = new ArrayDeque<>();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);

                // 비어 있을 때 방어 로직
                if(stk.isEmpty()){
                    stk.push(c);
                    continue;
                }
                //앞이랑 같지 않으면 제거
                if(stk.peek() != c){
                    stk.push(c);
                } else{
                    stk.pop();
                }
            }
            //끝났을 때 비어있으면 성공
            if(stk.isEmpty()){
                return 1;
            } else{
                return 0;
            }
        }
    }
}
