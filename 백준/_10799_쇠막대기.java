package 백준;
//[백준]10799 : 쇠막대기 - JAVA(자바)

//<새로 알게된 것>
// 스택문제의 문제해결력..!

//<궁금한 것>
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stack.push(c);
            }

            // ')' 가 들어왔을 경우 판단할 2가지
            // => 레이저의 닫기의 ')' 인가? OR 쇠막대기 닫기의 ')' 인가?
            // 1) 레이저 닫기의 ')' 일 경우 직전 괄호가 '('
            //  -> 스택에 남아있는 ( 의 갯수 더해주기
            // 2) 쇠막대기 닫기의 ')' 일 경우 직전 괄호가 ')'
            //  -> 닫히는 괄호이기 때문애 끝난지점을 알리는 +1 (그림그려서 풀면 이해 쉬움)

            else if (c == ')'){
                stack.pop();
                if(str.charAt(i-1) == '('){
                    sum += stack.size();
                }
                else if(str.charAt(i-1) == ')'){
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}

