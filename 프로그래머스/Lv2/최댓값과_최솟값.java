package 프로그래머스.Lv2;

import java.util.*;

class 최댓값과_최솟값{
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s," ");

        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        answer += String.valueOf(list.get(0))+" ";
        answer += String.valueOf(list.get(list.size()-1));

        return answer;
    }
}