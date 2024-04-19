package 프로그래머스.Lv2;

//소요시간 : 15분 🔍
//소요시간 : 5분

import java.util.*;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> stk = new Stack<>();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(stk.isEmpty() || stk.peek() != c){
                    stk.push(c);
                } else if (stk.peek() == c){
                    stk.pop();
                }
            }
            //반복문이 끝났을 때, 스택에 남아있으면 제거 실패
            if(!stk.isEmpty()){
                return 0;
            }
            return 1;
        }
    }
}
