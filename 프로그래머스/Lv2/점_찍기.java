package 프로그래머스.Lv2;

//[241219] 🔍

import java.util.*;

public class 점_찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        long newD = (long)d;
        long maxY = 0;
        for(long i=0; i<=d; i+=k){
            maxY = (long) Math.sqrt(newD*newD - i*i);    //각 x에 대한 최대 y값 도출
            answer += (maxY / k) +1;    //x=0 을 포함하기 위해 +1
        }
        return answer;
    }
}
