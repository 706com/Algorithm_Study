package 프로그래머스.Lv2;
//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
//전체를 구하고, 아무것도 입지 않는경우 -1 을 해준다.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.HashMap;
import java.util.Iterator;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();

        //key : 종류
        //value : 의상
        //key(종류)가 겹치면 그 key 에 의상들 갯수넣기(아예 착용안한것(NULL)도 포함하여 초깃값 1
        for(int i=0; i< clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }

        Iterator<Integer> it = map.values().iterator();
        //해쉬에 담겨있는 모든 종류값 곱하기.
        while(it.hasNext()){
            answer *=it.next();
        }

        //아무것도 안입었을때 -1 해주기
        return answer-1;

    }
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        의상 sol = new 의상();
        System.out.println(sol.solution(clothes));
    }
}
