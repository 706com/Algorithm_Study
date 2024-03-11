package 프로그래머스.Lv2;

//소요시간 : 34분

import java.util.Arrays;
import java.util.Collections;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] peoples = new Integer[people.length];
        for(int i=0; i<people.length; i++){
            peoples[i] = people[i];
        }
        Arrays.sort(peoples,Collections.reverseOrder());

        int point = peoples.length-1;
        for(int i=0; i<=point; i++){
            if(peoples[i]+peoples[point]<=limit){
                answer++;
                point--;
            }
            else{
                answer++;
            }
        }
        return answer;
    }
}
