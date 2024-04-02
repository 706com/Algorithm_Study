package 프로그래머스.Lv2;

//소요시간 : 15분 🔍

import java.util.*;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;

            Stack<Character> stk = new Stack<>();

            stk.push(s.charAt(0));
            for(int i=1; i<s.length(); i++){
                char c = s.charAt(i);
                if(stk.size()==0 || stk.peek() != c){
                    stk.push(c);
                } else{
                    stk.pop();
                }
            }

            if(stk.size()==0){
                return 1;
            } else{
                return 0;
            }
        }
    }
}
