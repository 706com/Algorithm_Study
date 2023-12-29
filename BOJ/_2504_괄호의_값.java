package BOJ;

//소요시간 : 1시간(실패 empty stack) -> 형변환 , 예외처리 주의하기.

//String : isInt() 메서드 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504_괄호의_값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stk = new Stack<>();
        int temp = 0;
        boolean error = false;
        for(int i=0; i<str.length(); i++){
            String c = String.valueOf(str.charAt(i));
            if(c.equals("(") || c.equals("[")){
                stk.push(c);
            }
            else if(c.equals(")")){
                if(stk.isEmpty()){
                    error = true;
                    break;
                }
                // () == 2
                if(stk.peek().equals("(")){
                    stk.pop();
                    stk.push("2");
                }
                // 앞이 숫자
                else if(isInt(stk.peek())){
                    temp = Integer.parseInt(stk.pop());
                    if(stk.peek().equals("(")){
                        stk.pop();
                        temp = temp * 2;
                        stk.push(String.valueOf(temp));
                    }
                    else{
                        error = true;
                        break;
                    }
                }
                // 앞이 '['
                else{
                    error = true;
                    break;
                }
            }
            else if(c.equals("]")){
                if(stk.isEmpty()){
                    error = true;
                    break;
                }
                // () == 2
                if(stk.peek().equals("[")){
                    stk.pop();
                    stk.push("3");
                }
                // 앞이 숫자
                else if(isInt(stk.peek())){
                    temp = Integer.parseInt(stk.pop());
                    if(stk.peek().equals("[")){
                        stk.pop();
                        temp = temp * 3;
                        stk.push(String.valueOf(temp));
                    }
                    else{
                        error = true;
                    }
                }
                // 앞이 '['
                else{
                    error = true;
                }
            }
            //후 작업 ( 숫자가 연속으로 두개 있으면 더하기)
            if(!stk.isEmpty() && isInt(stk.peek())){
                temp = Integer.parseInt(stk.pop());
                if(!stk.isEmpty() && isInt(stk.peek())){
                    int temp2 = Integer.parseInt(stk.pop());
                    temp = temp + temp2;
                    stk.push(String.valueOf(temp));
                }
                else{
                    stk.push(String.valueOf(temp));
                }
            }
            if(error){
                break;
            }
        }
        if(error){
            System.out.println("0");
        }
        else{
            System.out.println(stk.pop());
        }
    }
    static boolean isInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
