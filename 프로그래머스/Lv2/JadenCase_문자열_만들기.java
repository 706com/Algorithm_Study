package 프로그래머스.Lv2;
import java.util.*;

//[240401] 🔍
//[250207] 🔍

//❌ s.split(" ") (기본 동작)
//연속된 공백을 무시하며, 문자열 끝에 있는 공백이 사라집니다.

//✅ s.split(" ", -1)
//모든 공백을 유지하며, 문자열 끝에 있는 공백도 포함됩니다.

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String result = "";
        String[] arr = s.split(" ",-1);

        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length; i++){
            if(arr[i].length() == 0){
                result += " ";
                continue;
            }
            String token = arr[i].toLowerCase();

            // System.out.println(token.length());
            char upper = Character.toUpperCase(token.charAt(0));

            result += (upper + token.substring(1,token.length()));
            result += " ";
        }
        result = result.substring(0,result.length()-1);

        return result;
    }
}
