package 프로그래머스.Lv1;

import java.util.*;

public class 두_개_뽑아서_더하기 {

    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            HashSet<Integer> hs = new HashSet<>();
            //1. 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더한다.
            //2. 중복되는 수를 제거한다.
            for(int i=0; i<numbers.length; i++){
                for(int j=i+1; j<numbers.length; j++){
                    hs.add(numbers[i]+numbers[j]);
                }
            }
            //3. 오름차순으로 정렬한다.
            //4. 값을 반환한다.
            return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }

    /**
     * TreeSet을 사용해서 정렬까지 한 번에
     */
//    class Solution {
//        public int[] solution(int[] numbers) {
//            int[] answer = {};
//            TreeSet<Integer> ts = new TreeSet<>();
//
//            //1. 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더한다.
//            //2. 모든 수를 배열에 담는다. (중복 X)
//            //3. 오름차순으로 정렬한다.
//            for(int i=0; i<numbers.length; i++){
//                for(int j=i+1; j<numbers.length; j++){
//                    ts.add(numbers[i] + numbers[j]);
//                }
//            }
//
//            //4. 반환한다.
//            return ts.stream().mapToInt(Integer::intValue).toArray();
//        }

}
