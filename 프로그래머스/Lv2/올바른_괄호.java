package 프로그래머스.Lv2;
//[프로그래머스] 올바른 괄호 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//< 알고리즘 풀이 >
// 스택을 이용

//< 새로 알게된 것 >

//< 궁금한 것 >


import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    answer = false;
                    return answer;
                }
                else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
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
