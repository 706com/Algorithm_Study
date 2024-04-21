package 프로그래머스.Lv2;
//[프로그래머스] 주식가격 - JAVA(자바)

/*
입출력 예 설명
- 1초의 주가는 1이며 1초부터 5초까지 총 4초간 주가를 유지했습니다.
- 2초의 주가는 2이며 2초부터 5초까지 총 3초간 주가를 유지했습니다.
- 3초의 주가는 3이며 4초의 주가는 2로 주가가 떨어졌지만 3초에서 4초가 되기 직전까지의 1초간 주가가 유지 된것으로 봅니다. 따라서 5초까지 총 1초간 주가를 유지했습니다.
- 4초의 주가는 2이며 4초부터 5초까지 총 1초간 주가를 유지했습니다.
- 5초의 주가는 3이며 5초 이후로는 데이터가 없으므로 총 0초간 주가를 유지했습니다.
*/

import java.util.ArrayList;
import java.util.List;

public class 주식가격 {
    /**
     * 스택 접근
     */


    /**
     * 배열 접근
     * -> 통과는 했으나, 비효율적. O(N^2)
     */
    public int[] solution(int[] prices) {
        int[] answer = {};
        List<Integer> list =  new ArrayList<>();

        for(int i=0; i<prices.length; i++){
            int start = prices[i];
            int count = 0;
            for(int j = i+1; j<prices.length; j++){
                if(start <= prices[j]){
                    count++;
                }
                //주식이 떨어진 순간. 그 이후로는 볼 필요 X
                else{
                    count++;
                    break;
                }
            }
            list.add(count);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
