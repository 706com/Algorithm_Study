package 프로그래머스.Lv2;

//[250102] 🔍

import java.util.*;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // 배열의 크기 * 2 만큼 늘려서 원형 수열의 최대 조건 만족
        for(int i=0; i<2; i++){
            for(int x : elements){
                list.add(x);
            }
        }

        for(int i=0; i<elements.length; i++){
            for(int j=1; j<=elements.length; j++){
                // 잘라내기
                List<Integer> subList = list.subList(i,i+j);

                // 잘라낸 리스트 합 set에 넣기
                int sum = 0;
                for(int x : subList){
                    sum += x;
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
