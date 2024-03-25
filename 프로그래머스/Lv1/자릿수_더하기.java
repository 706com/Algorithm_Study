package 프로그래머스.Lv1;

import java.util.*;

public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;

        String str = String.valueOf(n);

        for(int i=0; i<str.length(); i++){
            answer += str.charAt(i) - '0';
        }

        return answer;
    }
}