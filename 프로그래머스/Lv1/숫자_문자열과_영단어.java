package 프로그래머스.Lv1;

//소요시간
//[240517] : 8분

import java.util.*;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        String answer = "";

        HashMap<String,String> hm = new HashMap<>();
        hm.put("one","1");
        hm.put("two","2");
        hm.put("three","3");
        hm.put("four","4");
        hm.put("five","5");
        hm.put("six","6");
        hm.put("seven","7");
        hm.put("eight","8");
        hm.put("nine","9");
        hm.put("zero","0");


        String str = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                str += c;
                if(hm.containsKey(str)){
                    answer += hm.get(str);
                    str="";
                }
            } else{
                answer += c;
            }
        }
        System.out.println(answer);
        return Integer.valueOf(answer);
    }
}
