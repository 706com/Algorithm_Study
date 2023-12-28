package BOJ._2_Silver;

//소요시간 : 14분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949_균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            boolean check = false;
            Stack<Character> stk = new Stack<>();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c=='(' || c=='['){
                    stk.push(c);
                }
                else if(c==')'){
                    if(!stk.isEmpty() && stk.peek() == '('){
                        stk.pop();
                        continue;
                    }
                    check = true;
                    break;
                }
                else if(c==']'){
                    if(!stk.isEmpty() && stk.peek() == '['){
                        stk.pop();
                        continue;
                    }
                    check = true;
                    break;
                }
            }
            if(!check && stk.isEmpty()){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}
