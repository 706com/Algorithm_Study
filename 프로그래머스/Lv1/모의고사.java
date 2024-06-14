package 프로그래머스.Lv1;

//소요시간 : 15분 (너무 깡 구현 느낌..?) + 스트림 리턴🔍
//[240614] : 25분

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};

        List<Integer> list = new ArrayList<>();
        int count1 = 0; //수포자1 맞춘 횟수
        int count2 = 0;
        int count3 = 0;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == answer1[i%5]){
                count1++;
            }
            if(answers[i] == answer2[i%8]){
                count2++;
            }
            if(answers[i] == answer3[i%10]){
                count3++;
            }
        }

        if(count1 >= count2 && count1 >= count3){
            list.add(1);
        }
        if(count2 >= count1 && count2 >= count3){
            list.add(2);
        }
        if(count3 >= count1 && count3 >= count2){
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
