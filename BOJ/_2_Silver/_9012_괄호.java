package BOJ._2_Silver;

//소요시간 : 8분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String str = br.readLine();
            Stack<Character> stk = new Stack<>();
            boolean check = false;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                if(c=='('){
                    stk.push(c);
                }
                else{
                    if(!stk.isEmpty() && stk.peek() == '('){
                        stk.pop();
                    }
                    else {
                        check = true;
                        break;
                    }
                }
            }
            if(!check && stk.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
