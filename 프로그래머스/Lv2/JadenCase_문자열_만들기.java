package 프로그래머스.Lv2;
import java.util.*;

//문자열 기능 기르기 문제 
//반례 조심

public class JadenCase_문자열_만들기 {


    class Solution {
        public String solution(String s) {
            String answer = "";
            String lowerStr = s.toLowerCase();
            String[] arr = lowerStr.split(" ");

            for(int i=0; i<arr.length; i++){
                System.out.println(arr[i]+" "+arr[i].length());
            }

            for(String x : arr){
                if(x.length()==0){
                    answer += " ";
                } else{
                    String a = x.substring(0,1);
                    String b = x.substring(1);
                    answer += a.toUpperCase();
                    answer += b+" ";
                }
            }
            // "  for the what 1what  " -> "  For The What 1what  "
            if(s.substring(s.length()-1).equals(" ")){
                return answer;
            }
            answer = answer.substring(0,answer.length()-1);
            return answer;
        }
    }
}
