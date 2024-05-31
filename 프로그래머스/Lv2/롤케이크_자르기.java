package 프로그래머스.Lv2;

//소요시간
//[240531] : 15분

// 1. 철수한테 모든 토핑을 다 가지게 한다. (해시에 담아놓기)
// 2. 0번째부터 순회하며 동생한테 토핑을 하나씩 나눠준다.
// 3. 만일 철수의 토핑이 0이 되면 해당 토핑정보를 삭제한다.
// 4. 순회를 하면서 해시의 사이즈(토핑갯수) 를 비교하며 같을 때 answer++
// 5. 만일 동생 토핑수가 더 많이질 때가 되면 stop

import java.util.*;

public class 롤케이크_자르기 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            HashMap<Integer, Integer> cs = new HashMap<>();
            HashMap<Integer, Integer> brother = new HashMap<>();

            //철수한테 모든 토핑 전달
            for(int i=0; i<topping.length; i++){
                cs.put(topping[i],cs.getOrDefault(topping[i],0)+1);
            }

            // //검증
            // for(int x : cs.keySet()){
            //     System.out.println(x+" : "+cs.get(x));
            // }

            //동생한테 하나씩 나눠주기
            for(int i=0; i<topping.length; i++){
                brother.put(topping[i],brother.getOrDefault(topping[i],0)+1);
                cs.put(topping[i],cs.getOrDefault(topping[i],0)-1);
                if(cs.get(topping[i]) == 0){
                    cs.remove(topping[i]);
                }
                if(brother.size() == cs.size()){
                    answer++;
                }

                if(brother.size()>cs.size()){
                    break;
                }
            }


            return answer;
        }
    }
}
