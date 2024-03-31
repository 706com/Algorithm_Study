package 프로그래머스.Lv1;

import java.util.*;

public class 평균_구하기 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;

            int sum = Arrays.stream(arr).sum();
            answer = (double)sum / arr.length;
            return answer;
        }
    }
}
