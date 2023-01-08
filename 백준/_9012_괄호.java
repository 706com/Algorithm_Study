package 백준;
//[백준]9012 : 괄호 - JAVA(자바)

// <새로 알게된 것>
// 전형적인 스택문제
// bracket = 괄호


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            sb.append(checkBracket(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }

    public static String checkBracket(String str){

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            // '(' 가 들어오면 스택에 넣기
            if(c == '('){
                stack.push(c);
            }
            // ')' 가 들어왔을 때, 안에 아무것도 없으면 비정상. 그게 아니라면 '('를 pop하기
            else if(c==')'){
                if(stack.isEmpty())
                    return "NO";
                else
                    stack.pop();
            }
        }

        //스택에 아무것도 없으면 정상
        if(stack.isEmpty())
            return "YES";
        else
            return "NO";

    }
}
