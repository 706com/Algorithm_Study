package 백준.Silver;
//[백준]4153 : 직각삼각형 - JAVA(자바)

//<새로 알게된 것>
//stack 사용법

//<궁금한 것>
//1. Stack<> 안에 String, Character 차이는?
//2. stack.empty() , stack.isempty() 차이점은?

//주석달기

//다시 짠게 어찌 더 더럽니

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949_균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(true) {
            boolean check = false;
            String str = br.readLine();

            if(str.equals(".")){
                break;
            }

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c== '['){
                    stack.push(c);
                    continue;
                }
                else if(c==')' || c==']'){
                    //), ] 만났을때 스택에 암것도 없으면 바로 break
                    if(stack.isEmpty()){
                        check = true;
                        sb.append("no").append('\n');
                        break;
                    }
                    //스택이 비어져있지 않을 때 각각
                    else{
                        if(c == ')'){
                            if(stack.peek() == '('){
                                stack.pop();
                            }
                            else{
                                sb.append("no").append('\n');
                                check = true;
                                break;
                            }
                        }

                        else if(c == ']'){
                            if(stack.peek() == '['){
                                stack.pop();
                            }
                            else{
                                sb.append("no").append('\n');
                                check = true;
                                break;
                            }
                        }
                    }
                }
            }
            //다 돌았는데 비어져있으면 정상
            if(!check) {
                if (stack.isEmpty()) {
                    sb.append("yes").append('\n');
                }
                //안비어져있으면 오류
                else {
                    sb.append("no").append('\n');
                }
            }
            //끝나고 초기화 시켜주기
            while(!stack.isEmpty()){
                stack.pop();
            }
        }
        System.out.println(sb);
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        while(true){
//            String str = br.readLine();
//            if(str.equals(".")){
//                break;
//            }
//            else{
//                sb.append(balance(str)).append('\n');
//            }
//        }
//        System.out.println(sb);
//    }
//    public static String balance(String str){
//
//        Stack<Character> stack = new Stack<>();
//
//        for(int i=0; i<str.length(); i++){
//            char c = str.charAt(i);
//
//            if(c == '(' || c == '['){
//                stack.push(c);
//            }
//
//            else if(c == ')'){
//                if(stack.isEmpty() || stack.peek() != '('){
//                    return "no";
//                }
//                else{
//                    stack.pop();
//                }
//            }
//
//            else if(c == ']'){
//                if(stack.isEmpty() || stack.peek() != '['){
//                    return "no";
//                }
//                else{
//                    stack.pop();
//                }
//            }
//        }
//
//        if(stack.isEmpty()){
//            return "yes";
//        }
//        else{
//            return "no";
//        }
//    }
