package 프로그래머스.Lv1;

import java.util.*;
//(num % 1 == 0)  //자연수 판별법

public class 정수_제곱근_판별 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            double num = Math.sqrt(n);
            if(num % 1 == 0){   //자연수 판별법
                answer = (long)Math.pow((num+1),2);
            }else{
                answer = -1;
            }
            return answer;
        }
    }
}
