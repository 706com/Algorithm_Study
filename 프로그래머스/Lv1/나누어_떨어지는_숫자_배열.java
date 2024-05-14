package 프로그래머스.Lv1;

// 소요시간
//[240515] : 5분

import java.util.*;

public class 나누어_떨어지는_숫자_배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            List<Integer> list = new ArrayList<>();

            for(int x : arr){
                if(x % divisor == 0){
                    list.add(x);
                }
            }
            Collections.sort(list);
            if(list.size() == 0){
                return new int[]{-1};
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

