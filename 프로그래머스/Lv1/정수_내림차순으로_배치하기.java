package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class 정수_내림차순으로_배치하기 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            String str = String.valueOf(n);
            Integer[] arr = new Integer[str.length()];

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                arr[i] = c - '0';
            }

            Arrays.sort(arr, Collections.reverseOrder());
            // System.out.println(Arrays.toString(arr));
            String temp = "";
            for(int x : arr){
                temp += String.valueOf(x);
            }
            answer = Long.parseLong(temp);
            return answer;
        }
    }
}
