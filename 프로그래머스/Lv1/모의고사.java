package 프로그래머스.Lv1;

//소요시간 : 15분 (너무 깡 구현 느낌..?) + 스트림 리턴🔍

import java.util.*;

public class 모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            List<Integer> list = new ArrayList<>();
            int[] x = {1,2,3,4,5};
            int[] y = {2,1,2,3,2,4,2,5};
            int[] z = {3,3,1,1,2,2,4,4,5,5};

            int px = 0;
            int py = 0;
            int pz = 0;

            int answerX = 0;
            int answerY = 0;
            int answerZ = 0;

            for(int answer : answers){
                if(px == x.length){
                    px = 0;
                }
                if(py == y.length){
                    py = 0;
                }
                if(pz == z.length){
                    pz = 0;
                }

                if(x[px] == answer){
                    answerX++;
                }
                if(y[py] == answer){
                    answerY++;
                }
                if(z[pz] == answer){
                    answerZ++;
                }

                px++;
                py++;
                pz++;
            }
            int max = Math.max(Math.max(answerX,answerY),answerZ);

            if(max == answerX){
                list.add(1);
            }
            if(max == answerY){
                list.add(2);
            }
            if(max == answerZ){
                list.add(3);
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
