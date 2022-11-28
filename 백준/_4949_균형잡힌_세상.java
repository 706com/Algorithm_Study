package 백준;
//[백준]4153 : 직각삼각형 - JAVA(자바)

//<새로 알게된 것>
//stack 사용법

//<궁금한 것>
//1. Stack<> 안에 String, Character 차이는?
//2. stack.empty() , stack.isempty() 차이점은?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949_균형잡힌_세상 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();

         while(true){
             String str = br.readLine();
             if(str.equals(".")){
                 break;
             }
             else{
                 sb.append(balance(str)).append('\n');
             }
         }
         System.out.println(sb);
     }
     public static String balance(String str){

         Stack<Character> stack = new Stack<>();

         for(int i=0; i<str.length(); i++){
             char c = str.charAt(i);

             if(c == '(' || c == '['){
                 stack.push(c);
             }

             else if(c == ')'){
                 if(stack.isEmpty() || stack.peek() != '('){
                     return "no";
                 }
                 else{
                     stack.pop();
                 }
             }

             else if(c == ']'){
                 if(stack.isEmpty() || stack.peek() != '['){
                     return "no";
                 }
                 else{
                     stack.pop();
                 }
             }
         }

         if(stack.isEmpty()){
             return "yes";
         }
         else{
             return "no";
         }
     }
}
