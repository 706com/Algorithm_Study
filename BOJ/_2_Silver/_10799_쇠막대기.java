package BOJ._2_Silver;
//[백준]10799 : 쇠막대기 - JAVA(자바)

//소요시간 : 29분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stk = new Stack<>();

        int result = 0;
        boolean check = false;  //이전노드가 '(' 인지 ')' 인지 판별하기 위함
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '(') {
                stk.push(c);
                check = true;
            }
            else{
                stk.pop();
                //이전 괄호가 '(' 면 레이저 발사 및 그때까지의 사이즈
                if(check) {
                    result += stk.size();
                }
                //이전 괄호가 ')' 면 막대기 닫고, +1
                else{
                    result ++;
                }
                check = false;
            }
        }
        System.out.println(result);
    }
}




