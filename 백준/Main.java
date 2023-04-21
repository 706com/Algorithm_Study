package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();

        int answer = solution(command);
        System.out.println(answer);
    }

    static int solution(String cmd){
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char before = '-';
        //1. '(' ')' 를 구분한다.
        for(int i=0; i<cmd.length(); i++){
            if(i>=1){
                before = cmd.charAt(i-1);
            }
            char c = cmd.charAt(i);
            //2. '('이면 스택에 넣어주고
            if(c == '('){
                stack.push(c);
            }
            //3. ) 이면 앞이 '(' 인지 ')' 인지 확인 하고 pop과 출력을 담아준다.
            else if( i>0 && c==')' && !stack.isEmpty()){
                if(before == '('){
                    stack.pop();
                    answer += stack.size();
                }
                else if(before == ')'){
                    answer +=1;
                    stack.pop();
                }
            }
        }
        return answer;
    }


}