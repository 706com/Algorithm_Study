package 백준;
//[백준]10799 : 쇠막대기 - JAVA(자바)

//<새로 알게된 것>
//

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

        int result = stackStick(str);
        System.out.println(result);
    }

    public static int stackStick(String str){
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int lazer = 0;
        int cnt = 0;
        boolean check = true;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
                if(check = false) {
                    cnt = 0;
                }
                else if(check = true){
                    cnt += 1;
                }
                check = true;
            }

            else if(c == ')'){
                stack.pop();
//                //한개 일 때 = 아무일도 없음
//                if(check == false && stack.size() == 0){
//                    lazer = 0;
//                }

                //
                if(check == true){
                    lazer += 1;

                }
                else if (check != true){
                    sum += lazer + 1 ;

                }
                check = false;

            }
        }

        return sum;
    }
}

