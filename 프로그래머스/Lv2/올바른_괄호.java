package 프로그래머스.Lv2;
//[프로그래머스] 올바른 괄호 - JAVA(자바)

//소요시간 : 5분
//[251016] : 3분

import java.util.*;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stk = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            switch(c){
                case '(':
                    stk.push(c);
                    break;
                case ')':
                    if(stk.isEmpty()){
                        return false;
                    }
                    stk.pop();
                    break;
            }
        }

        // 모두 순회하고 남아있으면 안됨
        if(!stk.isEmpty()){
            return false;
        }

        return true;
    }
}
