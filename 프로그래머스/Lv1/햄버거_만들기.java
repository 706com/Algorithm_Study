package 프로그래머스.Lv1;

//소요시간
//[240617] : 11분 -> 스택접근 (실패)
//[240617] : 20분 -> 리스트 접근

import java.util.*;

public class 햄버거_만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<ingredient.length; i++){

            int now = ingredient[i];
            list.add(now);

            if(list.size() < 4){
                continue;
            }

            if(now == 1){
                if(list.get(list.size()-2) == 3){
                    if(list.get(list.size()-3) == 2){
                        if(list.get(list.size()-4) == 1){
                            answer++;
                            for(int j=0; j<4; j++){
                                int last = list.size()-1;
                                list.remove(last);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
