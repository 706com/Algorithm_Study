package 프로그래머스.Lv2;

//[250317] 🔍

import java.util.*;

public class 시소_짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        Map<Double,Integer> map = new HashMap<>();

        for(int x : weights){
            double a = (x * 1.0);  //1:1
            double b = (x * 2.0) / 3.0;  //2:3
            double c = (x * 2.0) / 4.0; // 2:4
            double d = (x * 3.0) / 4.0; // 3:4

            if(map.containsKey(a)){
                answer += map.get(a);
            }
            if(map.containsKey(b)){
                answer += map.get(b);
            }
            if(map.containsKey(c)){
                answer += map.get(c);
            }
            if(map.containsKey(d)){
                answer += map.get(d);
            }
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return answer;
    }
}
