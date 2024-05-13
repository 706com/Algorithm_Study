package 프로그래머스.Lv2;

//소요시간
// [240311] : 34분 🔍
// [240513] : 30분 🔍

import java.util.Arrays;
import java.util.Collections;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 1. 내림차순으로 정렬한다.
        Integer[] peoples = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peoples,Collections.reverseOrder());
        // System.out.println(Arrays.toString(peoples));

        // 2. 투포인터 활용
        int p = people.length -1 ;

        for(int i=0; i<people.length; i++){
            // 2-1) 작거나 같으면 pointer 내리기
            if(peoples[i] + peoples[p]<=limit){
                answer++;
                p--;
            }
            // 2-2) limit 보다 두개의 값이 크면 pointer냅두기
            else{
                answer++;
            }
            // 2-3) i > pointer 되는 순간 탈출
            if(i>=p){
                break;
            }
        }

        return answer;
    }
}
