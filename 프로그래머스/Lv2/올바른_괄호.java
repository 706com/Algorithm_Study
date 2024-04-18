package 프로그래머스.Lv2;
//[프로그래머스] 올바른 괄호 - JAVA(자바)

//소요시간 : 5분

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stk.push(c);
            } else{
                //예외처리1) 비어있으면 리턴
                if(stk.isEmpty()){
                    return false;
                } else{
                    stk.pop();
                }
            }
        }
        //예외처리2) 다 끝났는데 남아있으면 리턴
        if(!stk.isEmpty()){
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        올바른_괄호 sol = new 올바른_괄호();
        sol.solution(s1);
        sol.solution(s2);
        sol.solution(s3);

    }
}
